package es.everis.gvias.core.appbase.common.utilidades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class Utilidades.
 */
public class Utilidades {

	/** Variable logger. */
	private static Logger logger = LogManager.getLogger();
	
	/** Constante HTTPS. */
	private static final String HTTPS = "https";
	
	/** Variable propiedades. */
	private static Properties propiedades;

	/** Variable postgres ip address. */
	private static String postgresIpAddress;

	/** Constante POSTGRES_IP_TAG. */
	private final static String POSTGRES_TAG = "{POSTGRES}";

	/** Constante POSTGRES_IP. */
	private final static String POSTGRES = "POSTGRES";

	/** Constante GUION. */
	private static final String GUION = " - ";
	
//	/** Constante CONFIGVISOR. */
//	private static final String CONFIGVISOR = "visor/config.json";

	static {
		try {
			String ficheroDeConfiguracionAEmplear = getPropertiesFromClasspath(
					"entorno.properties").getProperty(
					"ficheroDeConfiguracionAEmplear");
			propiedades = getPropertiesFromClasspath(ficheroDeConfiguracionAEmplear);


			if (propiedades.getProperty(POSTGRES) != null) {
				postgresIpAddress = propiedades.getProperty(POSTGRES);
			} else {
				postgresIpAddress = InetAddress.getLocalHost().getHostAddress();
			}

			logger.debug("Usando Postgres Server IP[" + postgresIpAddress + "]");

			Iterator<Object> keysIterator = propiedades.keySet().iterator();

			while (keysIterator.hasNext()) {
				String key = (String) keysIterator.next();
				String value = propiedades.getProperty(key);

				if ((value != null) && (value.contains(POSTGRES_TAG))) {
					value = value.replace(POSTGRES_TAG, postgresIpAddress);
					propiedades.setProperty(key, value);
				}
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	/** Constante CARACTERES_RAROS. */
	private static final HashMap<String, String> CARACTERES_RAROS = new HashMap<String, String>();
	static {
		CARACTERES_RAROS.put("Ã¡", "á");
		CARACTERES_RAROS.put("Ã€", "À");
		CARACTERES_RAROS.put("Ã¤", "ä");
		CARACTERES_RAROS.put("Ã©", "é");
		CARACTERES_RAROS.put("Ã¨", "è");
		CARACTERES_RAROS.put("Ã‰", "É");
		CARACTERES_RAROS.put("Ãª", "ê");
		CARACTERES_RAROS.put("Ã¦", "æ");
		CARACTERES_RAROS.put("Ã*", "í");
		CARACTERES_RAROS.put("Ã³", "ó");
		CARACTERES_RAROS.put("Ã“", "Ó");
		CARACTERES_RAROS.put("Ã¶", "ö");
		CARACTERES_RAROS.put("Ãº", "ú");
		CARACTERES_RAROS.put("Ã¼", "ü");
		CARACTERES_RAROS.put("Ã±", "ñ");
		CARACTERES_RAROS.put("Ã‘", "Ñ");
		CARACTERES_RAROS.put("Ã§", "ç");
		CARACTERES_RAROS.put("Ã­", "í");
	}

	/**
	 * Dame propiedad.
	 *
	 * @param nombrePropiedad
	 *            valor de nombre propiedad
	 * @return string
	 */
	public static String damePropiedad(String nombrePropiedad) {
		return propiedades.getProperty(nombrePropiedad);
	}

	/**
	 * Dame propiedad en una lista.
	 *
	 * @param nombrePropiedad
	 *            valor de nombre propiedad
	 * @return list
	 */
	public static List<String> damePropiedadAsList(String nombrePropiedad) {
		String propiedad = propiedades.getProperty(nombrePropiedad);

		if (propiedad != null) {
			String[] valores = propiedad.split(",");

			List<String> lista = new ArrayList<String>();

			for (int i = 0; i < valores.length; i++) {
				lista.add(valores[i]);
			}

			return lista;

		} else {
			return null;
		}
	}

	/**
	 * Obtiene el valor de properties from classpath.
	 *
	 * @param propFileName
	 *            valor de prop file name
	 * @return properties from classpath
	 * @throws IOException
	 *             Indica que ha ocurrido una I/O exception.
	 */
	private static Properties getPropertiesFromClasspath(String propFileName)
			throws IOException {
		// loading xmlProfileGen.properties from the classpath
		Properties props = new Properties();
		InputStream inputStream = Utilidades.class.getClassLoader()
				.getResourceAsStream(propFileName);

		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName
					+ "' not found in the classpath");
		}

		props.load(inputStream);

		return props;
	}


	/**
	 * Traducir caracteres raros.
	 *
	 * @param decode
	 *            valor de decode
	 * @return string
	 */
	public static String traducirCaracteresRaros(String decode) {
		String resultado = decode;

		for (Iterator<String> iterator = CARACTERES_RAROS.keySet().iterator(); iterator
				.hasNext();) {
			String cadenaATraducir = iterator.next();
			resultado = resultado.replace(cadenaATraducir,
					CARACTERES_RAROS.get(cadenaATraducir));
		}

		return resultado;
	}

	
	/**
	 * Formatear numero.
	 *
	 * @param dNumber
	 *            valor de d number
	 * @return string
	 */
	public String formatearNumero(double dNumber) {
		if (dNumber == 0)
			return "0,00";
		else {
			NumberFormat nf = new DecimalFormat("#,###,###.00");
			return nf.format(dNumber);
		}
	}

	/**
	 * Primera mayuscula.
	 *
	 * @param cadena
	 *            valor de cadena
	 * @return string
	 */
	public static String primeraMayuscula(String cadena) {

		if (cadena == null || cadena.length() == 0)
			return cadena;

		char[] caracteres = cadena.toCharArray();

		// El primer caracter siempre se pone en mayuscula.
		caracteres[0] = Character.toUpperCase(caracteres[0]);

		for (int i = 0; i < cadena.length() - 2; i++)
			if (caracteres[i] == ' ' || caracteres[i] == '.'
					|| caracteres[i] == ',')
				caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);

		return new String(caracteres);
	}

	/**
	 * Procesar textos nulos.
	 *
	 * @param sTexto
	 *            valor de s texto
	 * @return string
	 */
	public static String procesarTextosNulos(String sTexto) {

		if (sTexto == null) {
			return "";
		} else {
			return sTexto.trim();
		}
	}

	/**
	 * Formato fecha salida.
	 *
	 * @return simple date format
	 */
	public static SimpleDateFormat formatoFechaSalida() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}

	/**
	 * Formato fecha hora salida.
	 *
	 * @return simple date format
	 */

	public static SimpleDateFormat formatoFechaHoraSalida() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}

	/**
	 * Formato nombre apellidos.
	 *
	 * @param nombre
	 *            valor de nombre
	 * @param apellido1
	 *            valor de apellido1
	 * @param apellido2
	 *            valor de apellido2
	 * @return string
	 */
	public static String formatoNombreApellidos(String nombre,
			String apellido1, String apellido2) {

		if (nombre == null || nombre.trim().isEmpty())
			nombre = "";

		if (apellido1 == null || apellido1.trim().isEmpty())
			apellido1 = "";

		if (apellido2 == null || apellido2.trim().isEmpty())
			apellido2 = "";

		if (nombre.isEmpty()) {
			if (apellido1.isEmpty() && apellido2.isEmpty())
				return "";
			else if (!apellido1.isEmpty() && !apellido2.isEmpty())
				return apellido1 + "" + apellido2;
			else
				return apellido1 + apellido2;
		} else {
			if (apellido1.isEmpty() && apellido2.isEmpty())
				return nombre;
			else if (!apellido1.isEmpty() && !apellido2.isEmpty())
				return apellido1 + " " + apellido2 + ", " + nombre;
			else
				return apellido1 + apellido2 + ", " + nombre;
		}
	}

	/**
	 * From set to list.
	 *
	 * @param <T>
	 *            the generic type
	 * @param set
	 *            valor de set
	 * @return list
	 */
	public static <T> List<T> fromSetToList(Set<T> set) {
		List<T> list = new ArrayList<T>(set);

		return list;
	}

	/**
	 * Obtiene el valor de str diferencia fechas.
	 *
	 * @param startDate
	 *            valor de start date
	 * @param endDate
	 *            valor de end date
	 * @return str diferencia fechas
	 */
	public static String getStrDiferenciaFechas(Date startDate, Date endDate) {
		StringBuffer tiempoDiferencia = new StringBuffer();
		// milliseconds
		long different = endDate.getTime() - startDate.getTime();

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		if ((elapsedDays == 0) && (elapsedHours == 0) && (elapsedMinutes == 0)
				&& (elapsedSeconds == 0)) {
			tiempoDiferencia.append("Menos de un segundo");
		}

		if (elapsedDays > 0) {
			tiempoDiferencia.append(elapsedDays);
			tiempoDiferencia.append(" día");

			if (elapsedDays > 1) {
				tiempoDiferencia.append("s");
			}
		}

		if (elapsedHours > 0) {
			if (tiempoDiferencia.length() > 0) {
				tiempoDiferencia.append(" ");

				if ((elapsedMinutes == 0) && (elapsedSeconds == 0)) {
					tiempoDiferencia.append("y ");
				}
			}
			tiempoDiferencia.append(elapsedHours);
			tiempoDiferencia.append(" hora");

			if (elapsedHours > 1) {
				tiempoDiferencia.append("s");
			}

		}

		if (elapsedMinutes > 0) {
			if (tiempoDiferencia.length() > 0) {
				tiempoDiferencia.append(" ");

				if (elapsedSeconds == 0) {
					tiempoDiferencia.append("y ");
				}
			}
			tiempoDiferencia.append(elapsedMinutes);
			tiempoDiferencia.append(" minuto");

			if (elapsedMinutes > 1) {
				tiempoDiferencia.append("s");
			}
		}

		if (elapsedSeconds > 0) {
			if (tiempoDiferencia.length() > 0) {
				tiempoDiferencia.append(" y ");
			}

			tiempoDiferencia.append(elapsedSeconds);
			tiempoDiferencia.append(" segundo");

			if (elapsedSeconds > 1) {
				tiempoDiferencia.append("s");
			}
		}

		return tiempoDiferencia.toString();
	}

	
	/**
	 * Escape suspect characters.
	 *
	 * @param cadena
	 *            valor de cadena
	 * @return string
	 */
	public static String escapeSuspectCharacters(String cadena) {

		if (cadena != null) {
			return cadena.replaceAll("([^A-Za-z0-9.,'\"% _-]+=)", "");
		}

		return null;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
