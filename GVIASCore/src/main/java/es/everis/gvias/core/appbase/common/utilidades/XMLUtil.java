package es.everis.gvias.core.appbase.common.utilidades;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Class XMLUtil.
 */
public class XMLUtil {
	
	/** Constante LOGGER. */
	private static Logger logger = LogManager.getLogger();
	/**
	 * Class XMLException.
	 */
	public static class XMLException extends Exception {

		/** Constante serialVersionUID. */
		private static final long serialVersionUID = 5118145977808353316L;

		/**
		 * Crea una instancia de XML exception.
		 *
		 * @param arg0 valor de arg0
		 */
		public XMLException(String arg0) {
			super(arg0);
		}
	}

	/**
	 * A factory for creating XMLNewBean objects.
	 */
	public static interface XMLNewBeanFactory {
		
		/**
		 * Obtiene el valor de new instance.
		 *
		 * @param nombreTag valor de nombre tag
		 * @param defaultPackName valor de default pack name
		 * @return new instance
		 */
		public Object getNewInstance(String nombreTag, String defaultPackName);
	}

	/**
	 * Interface XMLUtilTagName.
	 */
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface XMLUtilTagName {
		
		/**
		 * Value.
		 *
		 * @return string
		 */
		String value();
	}

	/**
	 * Xml2 bean.
	 *
	 * @param tag valor de tag
	 * @param bean valor de bean
	 * @param log valor de log
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws SecurityException security exception
	 * @throws NoSuchFieldException no such field exception
	 */
	public static void xml2Bean(Element tag, Object bean, boolean log) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, InstantiationException, XMLException,
			ClassNotFoundException, SecurityException, NoSuchFieldException {
		xml2Bean(tag, bean, log, null);
	}

	/**
	 * Xml2 bean.
	 *
	 * @param tag valor de tag
	 * @param bean valor de bean
	 * @param log valor de log
	 * @param newBeanFactory valor de new bean factory
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws SecurityException security exception
	 * @throws NoSuchFieldException no such field exception
	 */
	public static void xml2Bean(Element tag, Object bean, boolean log, XMLNewBeanFactory newBeanFactory)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException,
			XMLException, ClassNotFoundException, SecurityException, NoSuchFieldException {
		xml2Bean(tag, bean, 1, bean.getClass().getPackage(), log, newBeanFactory);
	}

	/**
	 * Xml2 bean.
	 *
	 * @param tag valor de tag
	 * @param bean valor de bean
	 * @param nivel valor de nivel
	 * @param paquetePadre valor de paquete padre
	 * @param log valor de log
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws SecurityException security exception
	 * @throws NoSuchFieldException no such field exception
	 */
	public static void xml2Bean(Element tag, Object bean, int nivel, Package paquetePadre, boolean log)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException,
			XMLException, ClassNotFoundException, SecurityException, NoSuchFieldException {
		xml2Bean(tag, bean, 1, paquetePadre, log, null);
	}

	/**
	 * Xml2 bean.
	 *
	 * @param tag valor de tag
	 * @param bean valor de bean
	 * @param nivel valor de nivel
	 * @param paquetePadre valor de paquete padre
	 * @param log valor de log
	 * @param newBeanFactory valor de new bean factory
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws SecurityException security exception
	 * @throws NoSuchFieldException no such field exception
	 */
	@SuppressWarnings("unchecked")
	public static void xml2Bean(Element tag, Object bean, int nivel, Package paquetePadre, boolean log,
			XMLNewBeanFactory newBeanFactory) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException, XMLException, ClassNotFoundException,
			SecurityException, NoSuchFieldException {

		StringBuffer tabs = new StringBuffer();

		for (int n = 0; n < nivel; n++) {
			tabs.append("\t");
		}

		boolean isList = bean instanceof List<?>;
		NodeList tagsHijo = tag.getChildNodes();
		if (log) {
			logger.info(tabs + "<" + tag.getTagName() + "> "
					+ (isList ? "(lista)" : "(bean) hijos=" + tagsHijo.getLength()));
		}

		/**
		 * Rellenamos los atributos
		 */
		NamedNodeMap attributes = tag.getAttributes();
		setteaAttributos(bean, attributes, nivel, log);

		if (!isList) {

			/**
			 * Rellenamos los tags hijo
			 */
			setteaTagsHijos(bean, tagsHijo, nivel, paquetePadre, log, newBeanFactory);
		} else {
			List<Object> lista = (List<Object>) bean;

			int length = tagsHijo.getLength();
			if (length > 0) {
				for (int i = 0; i < length; i++) {
					Node nodoHijo = tagsHijo.item(i);

					if (nodoHijo instanceof Element) {
						Element tagHijo = (Element) nodoHijo;

						if (paquetePadre == null) {
							String txt = tagHijo.getTextContent();
							lista.add(txt);
							if (log) {
								logger.info(tabs + "\t" + txt);
							}
						} else {
							String nombreTag = tagHijo.getTagName();

							Class<?> superClass = bean.getClass();
							Type type = superClass.getGenericSuperclass();
							Type[] typeArguments = null;
							while (typeArguments == null && (superClass = superClass.getSuperclass()) != null) {
								if ((type instanceof ParameterizedType)) {
									typeArguments = ((ParameterizedType) type).getActualTypeArguments();
								}
							}

							String packageName = null;
							if (typeArguments != null) {
								/**
								 * En una lista sólo habrá un sólo parámetro
								 */
								Type typeArgument = typeArguments[0];
								if (typeArgument instanceof Class<?>) {
									packageName = ((Class<?>) typeArgument).getPackage().getName();
								}
							}

							if (packageName == null) {
								packageName = paquetePadre.getName();
							}

							String className = packageName + "." + capitalize(nombreTag);
							Object nuevo = getInstance(nombreTag, className, packageName, newBeanFactory);

							xml2Bean(tagHijo, nuevo, log, newBeanFactory);

							lista.add(nuevo);
						}
					}
				}
			} else {
				String nombreTag = tag.getTagName();

				throw new XMLException(
						String.format(
								"La etiqueta <%s> está asociada a un List por lo que debe forzosamente contener elementos hijo.",
								nombreTag));
			}
		}

	}

	/**
	 * Obtiene una instancia de XMLUtil.
	 *
	 * @param nombreTag valor de nombre tag
	 * @param className valor de class name
	 * @param defaultPackName valor de default pack name
	 * @param factory valor de factory
	 * @return instancia de XMLUtil
	 * @throws ClassNotFoundException class not found exception
	 * @throws InstantiationException instantiation exception
	 * @throws IllegalAccessException illegal access exception
	 */
	protected static Object getInstance(String nombreTag, String className, String defaultPackName,
			XMLNewBeanFactory factory) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object nuevo = null;
		if (factory != null && (nuevo = factory.getNewInstance(nombreTag, defaultPackName)) != null) {
			return nuevo;
		}

		Class<?> claseHijo = Class.forName(className);

		nuevo = claseHijo.newInstance();
		return nuevo;
	}

	/**
	 * Capitalize.
	 *
	 * @param string valor de string
	 * @return string
	 */
	private static String capitalize(String string) {
		StringBuffer stringBuffer = new StringBuffer(string);

		if (string.length() != 0) {
			char character = stringBuffer.charAt(0);

			if (character >= 97 && character <= 122) {
				character -= 32;
			}

			stringBuffer.setCharAt(0, character);
		}

		return stringBuffer.toString();
	}

	/**
	 * Settea attributos.
	 *
	 * @param bean valor de bean
	 * @param attributes valor de attributes
	 * @param nivel valor de nivel
	 * @param log valor de log
	 * @throws XMLException XML exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 */
	protected static void setteaAttributos(Object bean, NamedNodeMap attributes, int nivel, boolean log)
			throws XMLException, IllegalAccessException, InvocationTargetException {

		for (int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);

			String propiedad = attribute.getNodeName();
			String valorAtributo = attribute.getNodeValue();

			Method[] metodos = bean.getClass().getMethods();

			/**
			 * Asignamos el atributo
			 */
			for (Method metodo : metodos) {
				String methodName = metodo.getName();
				boolean esSetterPropiedad = methodName.equalsIgnoreCase("set" + propiedad);
				boolean tieneUnArgumento = (metodo.getParameterTypes().length == 1);

				if (!esSetterPropiedad || !tieneUnArgumento) {
					continue;
				}

				Class<?> tipoParametro = metodo.getParameterTypes()[0];
				Object valorSetter = null;

				if (tipoParametro.equals(Double.class) || tipoParametro.equals(double.class)) {
					valorSetter = Double.valueOf(valorAtributo);
				} else if (tipoParametro.equals(Float.class) || tipoParametro.equals(float.class)) {
					valorSetter = Float.valueOf(valorAtributo);
				} else if (tipoParametro.equals(Boolean.class) || tipoParametro.equals(boolean.class)) {
					valorSetter = Boolean.valueOf(valorAtributo);
				} else if (tipoParametro.equals(Integer.class) || tipoParametro.equals(int.class)) {
					valorSetter = Integer.valueOf(valorAtributo);
				} else if (tipoParametro.equals(String.class)) {
					valorSetter = valorAtributo;
				} else if (tipoParametro.equals(BigDecimal.class)) {
					valorSetter = new BigDecimal(valorAtributo);
				} else if (tipoParametro.equals(Short.class) || tipoParametro.equals(short.class)) {
					valorSetter = new Short(valorAtributo);
				} else {
					throw new XMLException("Un atributo no puede ser cargado en el método '" + methodName
							+ "' porque su tipo es desconido. Tipo: " + tipoParametro.getSimpleName());
				}

				StringBuffer tabs = new StringBuffer();

				for (int n = 0; n < nivel; n++) {
					tabs.append("\t");
				}

				if (log) {
					logger.info(tabs + "  " + propiedad + "=" + valorSetter);
				}
				metodo.invoke(bean, valorSetter);
				break;
			}
		}
	}

	/**
	 * Settea tags hijos.
	 *
	 * @param bean valor de bean
	 * @param tagsHijo valor de tags hijo
	 * @param nivel valor de nivel
	 * @param paquetePadre valor de paquete padre
	 * @param log valor de log
	 * @param newBeanFactory valor de new bean factory
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws SecurityException security exception
	 * @throws NoSuchFieldException no such field exception
	 */
	protected static void setteaTagsHijos(Object bean, NodeList tagsHijo, int nivel, Package paquetePadre, boolean log,
			XMLNewBeanFactory newBeanFactory) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException, XMLException, ClassNotFoundException,
			SecurityException, NoSuchFieldException {
		StringBuffer tabs = new StringBuffer();
		for (int n = 0; n < nivel; n++) {
			tabs.append("\t");
		}
		for (int i = 0; i < tagsHijo.getLength(); i++) {
			Node nodo = tagsHijo.item(i);

			if (nodo instanceof Element) {
				Element tagHijo = (Element) nodo;

				String propiedad = tagHijo.getNodeName();
				String valorTextoTag = tagHijo.getTextContent();

				Method[] metodos = bean.getClass().getMethods();

				/**
				 * Asignamos el texto del tag
				 */
				boolean setterFound = false;
				for (Method metodo : metodos) {
					boolean esSetterPropiedad = metodo.getName().equalsIgnoreCase("set" + propiedad);
					boolean tieneUnArgumento = (metodo.getParameterTypes().length == 1);

					if (!esSetterPropiedad || !tieneUnArgumento) {
						continue;
					}

					setterFound = true;

					Class<?> tipoParametro = metodo.getParameterTypes()[0];
					Object valorSetter = null;

					if (tipoParametro.equals(Double.class) || tipoParametro.equals(double.class)) {
						if (log) {
							logger.info(tabs + " Double " + propiedad + "=" + valorSetter);
						}
						valorSetter = Double.valueOf(valorTextoTag);
					} else if (tipoParametro.equals(Boolean.class) || tipoParametro.equals(boolean.class)) {
						if (log) {
							logger.info(tabs + " Boolean " + propiedad + "=" + valorSetter);
						}
						valorSetter = Boolean.valueOf(valorTextoTag);
					} else if (tipoParametro.equals(Float.class) || tipoParametro.equals(float.class)) {
						if (log) {
							logger.info(tabs + " Float " + propiedad + "=" + valorSetter);
						}
						valorSetter = Float.valueOf(valorTextoTag);
					} else if (tipoParametro.equals(BigDecimal.class)) {
						if (log) {
							logger.info(tabs + " BigDecimal " + propiedad + "=" + valorSetter);
						}
						valorSetter = new BigDecimal(valorTextoTag);
					} else if (tipoParametro.equals(Short.class) || tipoParametro.equals(short.class)) {
						if (log) {
							logger.info(tabs + " Short " + propiedad + "=" + valorSetter);
						}
						valorSetter = new Short(valorTextoTag);
					} else if (tipoParametro.equals(Integer.class) || tipoParametro.equals(int.class)) {
						if (log) {
							logger.info(tabs + " Integer " + propiedad + "=" + valorSetter);
						}
						valorSetter = Integer.valueOf(valorTextoTag);
					} else if (tipoParametro.equals(String.class)) {
						if (log) {
							logger.info(tabs + " String " + propiedad + "=" + valorSetter);
						}
						valorSetter = valorTextoTag;
					} else if (tipoParametro.isAssignableFrom(List.class)) {
						if (log) {
							logger.info(tabs + " List " + propiedad + "= ...");
						}
						Type tipoGenerico = metodo.getGenericParameterTypes()[0];

						if (tipoGenerico instanceof ParameterizedType
								&& ((ParameterizedType) tipoGenerico).getActualTypeArguments()[0].equals(String.class)) {
							valorSetter = new ArrayList<String>();

							xml2Bean(tagHijo, valorSetter, nivel + 1, null, log, newBeanFactory);
						} else {
							if (tipoGenerico instanceof ParameterizedType) {
								Type typeArg = ((ParameterizedType) tipoGenerico).getActualTypeArguments()[0];
								Class<?> classArg = (Class<?>) typeArg;
								paquetePadre = classArg.getPackage();
							}
							valorSetter = new ArrayList<Object>();

							xml2Bean(tagHijo, valorSetter, nivel + 1, paquetePadre, log, newBeanFactory);
						}

					} else if (Enum.class.isAssignableFrom(tipoParametro)) {
						if (log) {
							logger.info(tabs + " Enum " + propiedad + "=" + valorSetter);
						}
						Field field = tipoParametro.getDeclaredField(valorTextoTag);
						valorSetter = field.get(null);
					} else {
						if (log) {
							logger.info(tabs + " " + tipoParametro + " " + propiedad);
						}
						valorSetter = tipoParametro.newInstance();

						xml2Bean(tagHijo, valorSetter, nivel + 1, paquetePadre, log, newBeanFactory);
					}

					metodo.invoke(bean, valorSetter);
				}

				if (!setterFound) {
					if (log) {
						logger.info(tabs + " No se encontró un setter para la propiedad '" + propiedad
								+ "' en la clase " + bean.getClass());
					}
				}
			}
			// else {
			// if (log) {
			// LOGGER.info(nodo + " no es un elemento válido.");
			// }
			// }
		}

	}

	/**
	 * Indent xml.
	 *
	 * @param xmlStr valor de xml str
	 * @return true, si todo ha ido bien
	 */
	public static boolean indentXml(StringBuffer xmlStr) {
		if (logger.isDebugEnabled()) {
			logger.debug("indentXml(StringBuffer) - start"); //$NON-NLS-1$
		}

		try {
			DocumentBuilder newDocBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(xmlStr.toString()));

			Document root = newDocBuilder.parse(inputSource);

			StringWriter stringWriter = indentXml(root);
			if (stringWriter == null) {
				return false;
			}

			xmlStr.setLength(0);
			xmlStr.append(stringWriter.toString());

			if (logger.isDebugEnabled()) {
				logger.debug("indentXml(StringBuffer) - end"); //$NON-NLS-1$
			}
			return true;

		} catch (SAXException e) {
			logger.error("indentXml(StringBuffer) SaxExcepcion", e); //$NON-NLS-1$
			logger.info("SaxException - Error al intentar indentar el XML. Continuamos despues del error.");
		} catch (IOException e) {
			logger.error("indentXml(StringBuffer) IOException", e); //$NON-NLS-1$
			logger.info("IOException - Error al intentar indentar el XML. Continuamos despues del error.");
		} catch (ParserConfigurationException e) {
			logger.error("indentXml(StringBuffer) ConfigurationException", e); //$NON-NLS-1$
			logger.info("ConfigurationException - Error al intentar indentar el XML. Continuamos despues del error.");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("indentXml(StringBuffer) - end"); //$NON-NLS-1$
		}
		return false;
	}

	/**
	 * Indent xml.
	 *
	 * @param root valor de root
	 * @return string writer
	 */
	public static StringWriter indentXml(Document root) {
		try {
			// Write file
			DOMSource domsource = new DOMSource(root);
			StringWriter stringWriter = new StringWriter(1024);
			StreamResult output = new StreamResult(stringWriter); // new

			// Set up
			TransformerFactory transfabrik = TransformerFactory.newInstance();
			Transformer sTransformer;
			sTransformer = transfabrik.newTransformer();
			sTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			sTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");

			sTransformer.transform(domsource, output);
			return stringWriter;
		} catch (TransformerConfigurationException e) {
			logger.error("indentXml(StringBuffer)", e); //$NON-NLS-1$
			logger.info("Error al intentar indentar el XML. Continuamos despues del error.");
			return null;
		} catch (TransformerException e) {
			logger.error("indentXml(StringBuffer)", e); //$NON-NLS-1$
			logger.info("Error al intentar indentar el XML. Continuamos despues del error.");
			return null;
		}
	}

	/**
	 * Bean2xml.
	 *
	 * @param indent valor de indent
	 * @param bean valor de bean
	 * @param salidaEnUTF8 valor de salida en ut f8
	 * @return byte[]
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws UnsupportedEncodingException unsupported encoding exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws ParserConfigurationException parser configuration exception
	 * @throws TransformerException transformer exception
	 */
	public static byte[] bean2xml(boolean indent, Object bean, boolean salidaEnUTF8) throws IllegalArgumentException,
			UnsupportedEncodingException, IllegalAccessException, InvocationTargetException, InstantiationException,
			XMLException, ClassNotFoundException, ParserConfigurationException, TransformerException {
		return bean2xml(indent, bean, salidaEnUTF8, false);
	}

	/**
	 * Bean2xml.
	 *
	 * @param indent valor de indent
	 * @param bean valor de bean
	 * @param salidaEnUTF8 valor de salida en ut f8
	 * @param dateWithTime valor de date with time
	 * @return byte[]
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws UnsupportedEncodingException unsupported encoding exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws ParserConfigurationException parser configuration exception
	 * @throws TransformerException transformer exception
	 */
	public static byte[] bean2xml(boolean indent, Object bean, boolean salidaEnUTF8, boolean dateWithTime)
			throws IllegalArgumentException, UnsupportedEncodingException, IllegalAccessException,
			InvocationTargetException, InstantiationException, XMLException, ClassNotFoundException,
			ParserConfigurationException, TransformerException {

		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		bean2xml(bean, null, doc, dateWithTime, 0, new HashMap<Object, Integer>());

		byte[] xmlString = dom2String(doc, salidaEnUTF8, indent);

		return xmlString;
	}

	/**
	 * Bean2xml.
	 *
	 * @param bean valor de bean
	 * @param padre valor de padre
	 * @param doc valor de doc
	 * @param dateWithTime valor de date with time
	 * @param deep valor de deep
	 * @param processedObjects valor de processed objects
	 * @return element
	 * @throws IllegalArgumentException illegal argument exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws InvocationTargetException invocation target exception
	 * @throws InstantiationException instantiation exception
	 * @throws XMLException XML exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws ParserConfigurationException parser configuration exception
	 */
	protected static Element bean2xml(Object bean, Element padre, Document doc, boolean dateWithTime, int deep,
			Map<Object, Integer> processedObjects) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException, XMLException, ClassNotFoundException,
			ParserConfigurationException {

		if (processedObjects != null) {
			/**
			 * Si se ha mostrado a un nivel más profundo, se muestra otra vez.
			 * Si no, se omite.
			 */
			if (processedObjects.containsKey(bean)) {
				int objectDeep = processedObjects.get(bean);

				if (deep > objectDeep) {
					return null;
				}
			}

			processedObjects.put(bean, deep);
		}

		Class<?> clase = bean.getClass();

		String rootName = null;

		String clazzName = clase.getName();
		XMLUtilTagName tagNameAnnot = clase.getAnnotation(XMLUtilTagName.class);

		if (tagNameAnnot != null) {
			rootName = tagNameAnnot.value();
		} else {
			rootName = getSimpleClassName(clazzName);
		}

		try {

			Element root = doc.createElement(rootName);

			if (padre != null) {
				padre.appendChild(root);
			} else {
				doc.appendChild(root);
			}

			Method[] metodos = clase.getMethods();

			for (int i = 0; i < metodos.length; i++) {
				Method metodo = metodos[i];
				String nombreMetodo = metodo.getName();

				if ( metodo.getParameterTypes().length == 0 && !"getClass".equals(nombreMetodo) && nombreMetodo.startsWith("get")) {

					Object result = metodo.invoke(bean, (Object[]) null);

					String nombrePropiedad = decapitalize(nombreMetodo.replaceFirst("get", ""));

					Element tagPropiedad = doc.createElement(nombrePropiedad);
					root.appendChild(tagPropiedad);

					if (result != null) {
						if (result instanceof List<?>) {
							List<?> lstResult = (List<?>) result;
							for (Iterator<?> it = lstResult.iterator(); it.hasNext();) {
								Object hijo = it.next();
								if (hijo != null) {
									if (!isBasicType(hijo)) {
										bean2xml(hijo, tagPropiedad, doc, dateWithTime, deep + 1, processedObjects);
									} else {
										Element tagElement = doc.createElement(hijo.getClass().getSimpleName());
										Text txtNode = doc.createCDATASection(hijo.toString());
										tagElement.appendChild(txtNode);
										tagPropiedad.appendChild(tagElement);
									}
								}
							}
						} else if (isBasicType(result)) {
							Text txtNode = doc.createCDATASection(result.toString());
							tagPropiedad.appendChild(txtNode);
						} else if (result.getClass().isArray()) {
							for (int j = 0; j < Array.getLength(result); j++) {
								Object hijo = Array.get(result, j);
								if (hijo != null) {
									if (!isBasicType(hijo)) {
										bean2xml(hijo, tagPropiedad, doc, dateWithTime, deep + 1, processedObjects);
									} else {
										Element tagElement = doc.createElement(hijo.getClass().getSimpleName());
										Text txtNode = doc.createCDATASection(hijo.toString());
										tagElement.appendChild(txtNode);
										tagPropiedad.appendChild(tagElement);
									}
								}
							}
						} else if (result instanceof Date) {
							SimpleDateFormat sdf = null;
							if (dateWithTime) {
								sdf = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
							} else {
								sdf = new SimpleDateFormat("dd/MM/yyyy");
							}
							String fechaStr = sdf.format((Date) result);
							Text txtNode = doc.createCDATASection(fechaStr);
							tagPropiedad.appendChild(txtNode);
						} else {
							bean2xml(result, tagPropiedad, doc, dateWithTime, deep + 1, processedObjects);
						}
					}
				}

			}

			return root;
		} catch (DOMException e) {
			logger.error("clazzName=" + clazzName + "; simpleClassName=" + rootName, e);
			throw e;
		}
	}

	/**
	 * Comprueba el valor de basic type.
	 *
	 * @param obj valor de obj
	 * @return true, si basic type
	 */
	protected static boolean isBasicType(Object obj) {
		return obj instanceof String || obj instanceof Integer || obj instanceof Double || obj instanceof Boolean
				|| obj instanceof Float || obj instanceof Byte || obj instanceof BigDecimal || obj instanceof Short;
	}

	/**
	 * Dom2 string.
	 *
	 * @param doc valor de doc
	 * @param salidaEnUTF8 valor de salida en ut f8
	 * @param indent valor de indent
	 * @return byte[]
	 * @throws TransformerException transformer exception
	 * @throws UnsupportedEncodingException unsupported encoding exception
	 */
	protected static byte[] dom2String(Document doc, boolean salidaEnUTF8, boolean indent) throws TransformerException,
			UnsupportedEncodingException {
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		transformer = tfFactory.newTransformer();
		if (indent) {
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
		}

		Source source = new DOMSource(doc);

		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		transformer.transform(source, result);

		return salidaEnUTF8 ? writer.toString().getBytes("UTF-8") : writer.toString().getBytes();
	}

	/**
	 * Obtiene el valor de simple class name.
	 *
	 * @param className valor de class name
	 * @return simple class name
	 */
	protected static String getSimpleClassName(String className) {
		int idx = className.lastIndexOf('.');

		String simple = className.substring(idx + 1);

		return simple;
	}

	/**
	 * Decapitalize.
	 *
	 * @param texto valor de texto
	 * @return string
	 */
	protected static String decapitalize(String texto) {
		if (texto.length() > 1) {
			return texto.substring(0, 1).toLowerCase() + texto.substring(1);
		} else {
			return texto.toLowerCase();
		}
	}
	
    /**
     * Bytes to xml.
     *
     * @param xml valor de xml
     * @return document
     * @throws SAXException SAX exception
     * @throws ParserConfigurationException parser configuration exception
     * @throws IOException Indica que ha ocurrido una I/O exception.
     */
    public static Document bytesToXml(byte[] xml) 
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(xml));
    }

}
