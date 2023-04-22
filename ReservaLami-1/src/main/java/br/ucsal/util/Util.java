package br.ucsal.util;

import java.time.LocalDateTime;

import org.springframework.util.ObjectUtils;

public class Util {
	
	public static boolean isValidInterval(LocalDateTime start, LocalDateTime end) {
		return !ObjectUtils.isEmpty(start) && !ObjectUtils.isEmpty(end) && start.isBefore(end);
	}
}