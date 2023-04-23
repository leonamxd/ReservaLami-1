package br.ucsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.ucsal.exceptions.BussinessException;
import br.ucsal.models.Reservation;
import br.ucsal.models.StatusReservation;
import br.ucsal.repositories.ReservationRepository;
import br.ucsal.util.Util;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private LaboratoryService laboratoryService;

	public Reservation insertReservation(Reservation newReservation) throws Exception {

		// Verifica disponibilidade do laboratorio
		if (!laboratoryService.searchAvailability(newReservation.getLaboratory().getId())) {
			// TODO criar exceptions especificas para erros de negocio
			throw new BussinessException("Este labóratório está indisponível para uso.");
		}
		
		if (!Util.isValidInterval(newReservation.getStartTime(), newReservation.getEndTime())) {
			throw new BussinessException("Datas selecionadas não estão em intervalo válido.");
		}

		// Verifica se a disciplina escolhida tem prioridade no laboratorio escolhido
		if (!ObjectUtils.isEmpty(newReservation.getDiscipline())
				&& newReservation.getDiscipline().getPrioritaryLab().equals(newReservation.getLaboratory())) {

			// busca reservas no intervalo de data da nova reserva
			List<Reservation> reservasConflitantes = reservationRepository
					.findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(newReservation.getStartTime(),
							newReservation.getEndTime());

			// verifica se nas reservas conflitantes, já existe alguma que é prioridade
			boolean conflitoPrioridade = reservasConflitantes.stream()
					.anyMatch(reservation -> reservation.getDiscipline().equals(newReservation.getDiscipline()));

			if (conflitoPrioridade) {
				throw new BussinessException("Já existe reserva para disciplina com prioridade neste laboratório.");
			}

			// cancela reservas conflitantes não prioritárias
			reservasConflitantes.stream()
					.forEach(reservation -> reservation.setStatusReservation(StatusReservation.CANCELED_SYSTEM));
			reservationRepository.saveAll(reservasConflitantes);
			
			//TODO implementar notificação das reservas canceladas

		}

		return reservationRepository.save(newReservation);
	}

	public Reservation cancelReservation(Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		reservation.get().setStatusReservation(StatusReservation.CANCELED_USER);
		return reservationRepository.save(reservation.get());
	}
}