package stream_api.desafios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

		// Desafio 1 - Mostre a lista na ordem numérica:
		System.out.println("Desafio 1 - Mostre a lista na ordem numérica:");
		numeros.stream().sorted().forEach(System.out::println);

		// Desafio 2 - Imprima a soma dos números pares da lista:
		System.out.println("Desafio 2 - Imprima a soma dos números pares da lista:");
		List<Integer> numeroPares = numeros.stream().filter(n -> n % 2 == 0).map(n -> n * 2).toList();
		numeroPares.stream().sorted().forEach(System.out::println);

		// Desafio 3 - Verifique se todos os números da lista são positivos:
		System.out.println("Desafio 3 - Verifique se todos os números da lista são positivos:");
		System.out.println(numeros.stream().allMatch(n -> n > 0));

		// Desafio 4 - Remova todos os valores ímpares:
		System.out.println("Desafio 4 - Remova todos os valores ímpares:");
		List<Integer> numerosPares = numeros.stream().filter(n -> n % 2 == 0).toList();
		numerosPares.stream().forEach(System.out::println);

		// Desafio 5 - Calcule a média dos números maiores que 5:
		System.out.println("Desafio 5 - Calcule a média dos números maiores que 5:");
		OptionalDouble media = numeros.stream().filter(n -> n > 5).mapToInt(Integer::intValue).average();
		System.out.println(media);
		// Desafio 6 - Verificar se a lista contém algum número maior que 10:
		System.out.println("Desafio 6 - Verificar se a lista contém algum número maior que 10:");
		System.out.println(numeros.stream().allMatch(n -> n > 10));

		// Desafio 7 - Encontrar o segundo número maior da lista:
		System.out.println("Desafio 7 - Encontrar o segundo número maior da lista:");
		System.out.println(numeros.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst());

		// Desafio 8 - Somar os dígitos de todos os números da lista:
		System.out.println("Desafio 8 - Somar os dígitos de todos os números da lista:");
		System.out.println(
				numeros.stream().flatMap(c -> String.valueOf(c).chars().mapToObj(v -> Character.getNumericValue(v)))
						.mapToInt(Integer::intValue).sum());

		// Desafio 9 - Verificar se todos os números da lista são distintos (não se
		// repetem):
		System.out.println("Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):");
		System.out.println(numeros.stream().allMatch(new HashSet<>()::add));

		// Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
		System.out.println("Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:");
		Map<String, List<Integer>> numerosMultiplosdeCincoOuTres = numeros.stream().filter(n -> n % 2 != 0)
				.filter(m -> m % 3 == 0 || m % 5 == 0).collect(Collectors.groupingBy(n -> {
					if (n % 3 == 0 && n % 5 == 0) {
						return "Multiplos de 3 e 5";
					} else if (n % 3 == 0) {
						return "Multiplos de 3";
					} else {
						return "Multiplos de 5";
					}
				}));
		numerosMultiplosdeCincoOuTres.forEach((key, value) -> System.out.println(key + ":" + value));

		// Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:
		System.out.println("Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:");

		Integer m = numeros.stream().mapToInt(n -> n * n).sum();
		System.out.println(m);

		// Desafio 12 - Encontre o produto de todos os números da lista:
		System.out.println("Desafio 12 - Encontre o produto de todos os números da lista:");

		int x = numeros.stream().reduce(1, (a, b) -> a * b);
		System.out.println(x);

		// Desafio 13 - Filtrar os números que estão dentro de um intervalo:
		System.out.println("Desafio 13 - Filtrar os números que estão dentro de um intervalo:");

		System.out.println(numeros.stream().sorted().filter(n -> n >= 5 && n <= 10).toList());

		// Desafio 14 - Encontre o maior número primo da lista:
		System.out.println("Desafio 14 - Encontre o maior número primo da lista:");
		System.out.println(numeros.stream().sorted().filter(Program::isPrime).max(Integer::compareTo));

		// Desafio 15 - Verifique se a lista contém pelo menos um número negativo:
		System.out.println("Desafio 15 - Verifique se a lista contém pelo menos um número negativo:");

		numeros.stream().filter(n -> n < 0).forEach(System.out::println);

		// Desafio 16 - Agrupe os números em pares e ímpares:
		System.out.println("Desafio 16 - Agrupe os números em pares e ímpares:");
		Map<Boolean, List<Integer>> agrupados = numeros.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		List<Integer> pares = agrupados.get(true);
		List<Integer> impares = agrupados.get(false);
		System.out.println("Números pares: " + pares);
		System.out.println("Números ímpares: " + impares);

		// Desafio 17 - Filtrar os números primos da lista:
		System.out.println("Desafio 17 - Filtrar os números primos da lista:");
		numeros.stream().filter(Program::isPrime).forEach(n -> System.out.print(n + " "));

		// Desafio 18 - Verifique se todos os números da lista são iguais:
		System.out.println("\nDesafio 18 - Verifique se todos os números da lista são iguais:");

		System.out.println(numeros.stream().distinct().count() == 1);

		// Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5:
		System.out.println("Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5:");
		System.out.println(numeros.stream().filter(n -> n % 3 == 0 && n % 5 == 0).mapToInt(Integer::intValue).sum());

	}

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
