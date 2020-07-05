/**
 * 
 */
package net.brilliant.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import net.brilliant.exceptions.ExecutionContextException;

/**
 * @author bqduc
 *
 */
public class BeanUtility {
  /**
   * String used to separate multiple properties inside of embedded
   * beans.
   */
  private static final String PROPERTY_SEPARATOR = ".";

  /**
   * an empty object array used for null parameter method reflection
   */
  private static Object[] NO_ARGUMENTS_ARRAY = new Object[] {
  };

  private BeanUtility() {
  }

  private static class BeanUtilitySingleton {
  	private static BeanUtility INSTANCE = new BeanUtility();
  }

  public static BeanUtility getInstance() {
  	return BeanUtilitySingleton.INSTANCE;
  }

	private Object doCopyBean(String[] propertyNames, Object sourceBean, Object targetBean) {
		PropertyDescriptor targetPropDesc = null;
		PropertyDescriptor sourcePropDesc = null;
		Object value;
		for (String propertyName :propertyNames) {
			if ("class".equalsIgnoreCase(propertyName))
				continue;

			try {
				sourcePropDesc = PropertyUtils.getPropertyDescriptor(sourceBean, propertyName);
				targetPropDesc = PropertyUtils.getPropertyDescriptor(targetBean, propertyName);
				if (null==targetPropDesc || null==sourcePropDesc)
					continue;

				value = sourcePropDesc.getReadMethod().invoke(sourceBean);
				targetPropDesc.getWriteMethod().invoke(targetBean, value);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		return targetBean;
	}

	private String[] getPropertyNames(Object bean) {
		List<String> propNams = new ArrayList<>();
		try {
			PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(bean.getClass());
			for (PropertyDescriptor pd :propertyDescriptors) {
				propNams.add(pd.getName());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return propNams.toArray(new String[0]);
	}

	public Object copyBeanData(Object sourceBean, Object targetBean) {
		String[] propertyNames = this.getPropertyNames(targetBean);
		return doCopyBean(propertyNames, sourceBean, targetBean);
	}

	public Object copyBeanData(Object sourceBean, Object targetBean, String[] excludedAttributes) {
		String[] propertyNames = this.getPropertyNames(targetBean);
		List<String> finalPropertyNames = ListUtility.createList();
		List<String> excludedPropertyNames = ListUtility.createList(excludedAttributes);
		for (String property :propertyNames) {
			if (excludedPropertyNames.contains(property))
				continue;

			finalPropertyNames.add(property);
		}
		return doCopyBean(finalPropertyNames.toArray(new String[0]), sourceBean, targetBean);
	}

	public static Object buildObject(Object targetBean, Map<String, Object> params) throws IllegalAccessException, InvocationTargetException {
		for (String key :params.keySet()) {
				BeanUtils.setProperty(targetBean, key, params.get(key));
		}
		return targetBean;
	}

	public static List<String> getBeanPropertyNames(Class<?> beanClass) throws IntrospectionException {
		List<String> propertyNames = ListUtility.createArrayList();
		String propName = null;
		BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		for (int i=0; i < descriptors.length; i++) {
    	propName = descriptors[i].getName();
    	if (descriptors[i].getPropertyType().isPrimitive()){
      	propertyNames.add(propName);
    	}
    	//System.out.println("Property with Name: " + propName + " and Type: " + propType);
    }
		return propertyNames;
	}

	public static Object getBeanProperty(Object bean, String propertyName)
      throws
          NoSuchMethodException,
          InvocationTargetException,
          IllegalAccessException {
		return getObjectAttribute(bean, propertyName);
	}

	/**
   * <p>Gets the specified attribute from the specified object.  For example,
   * <code>getObjectAttribute(o, "address.line1")</code> will return
   * the result of calling <code>o.getAddress().getLine1()</code>.<p>
   *
   * <p>The attribute specified may contain as many levels as you like. If at
   * any time a null reference is acquired by calling one of the successive
   * getter methods, then the return value from this method is also null.</p>
   *
   * <p>When reading from a boolean property the underlying bean introspector
   * first looks for an is&lt;Property&gt; read method, not finding one it will
   * still look for a get&lt;Property&gt; read method.  Not finding either, the
   * property is considered write-only.</p>
   *
   * @param bean the bean to set the property on
   * @param propertyName the name of the propertie(s) to retrieve.  If this is
   *        null or the empty string, then <code>bean</code> will be returned.
   * @return the object value of the bean attribute
   *
   * @throws PropertyNotFoundException indicates the the given property
   *         could not be found on the bean
   * @throws NoSuchMethodException Not thrown
   * @throws InvocationTargetException if a specified getter method throws an
   *   exception.
   * @throws IllegalAccessException if a getter method is
   *   not public or property is write-only.
   */
  public static Object getObjectAttribute(Object bean, String propertyName)
      throws
          NoSuchMethodException,
          InvocationTargetException,
          IllegalAccessException {


      Object result = bean;

      StringTokenizer propertyTokenizer = new StringTokenizer(propertyName, PROPERTY_SEPARATOR);
      Class<?> resultClass = null;
      String currentPropertyName = null;

      PropertyDescriptor propertyDescriptor = null;

      Method readMethod = null;

      // Run through the tokens, calling get methods and
      // replacing result with the new object each time.
      // If the result equals null, then simply return null.
      while (propertyTokenizer.hasMoreElements() && result != null) {
          resultClass = result.getClass();
          currentPropertyName = propertyTokenizer.nextToken();

          propertyDescriptor = getPropertyDescriptor(currentPropertyName, resultClass);

          readMethod = propertyDescriptor.getReadMethod();
          if (readMethod == null) {
              throw new IllegalAccessException(
                  "User is attempting to "
                      + "read from a property that has no read method.  "
                      + " This is likely a write-only bean property.  Caused "
                      + "by property ["
                      + currentPropertyName
                      + "] on class ["
                      + resultClass
                      + "]");
          }

          result = readMethod.invoke(result, NO_ARGUMENTS_ARRAY);
      }

      return result;
  }

	/**
   * <p>Gets the specified attribute from the specified object.  For example,
   * <code>getObjectAttribute(o, "address.line1")</code> will return
   * the result of calling <code>o.getAddress().getLine1()</code>.<p>
   *
   * <p>The attribute specified may contain as many levels as you like. If at
   * any time a null reference is acquired by calling one of the successive
   * getter methods, then the return value from this method is also null.</p>
   *
   * <p>When reading from a boolean property the underlying bean introspector
   * first looks for an is&lt;Property&gt; read method, not finding one it will
   * still look for a get&lt;Property&gt; read method.  Not finding either, the
   * property is considered write-only.</p>
   *
   * @param bean the bean to set the property on
   * @param propertyNames the name of the propertie(s) to retrieve.  If this is
   *        null or the empty string, then <code>bean</code> will be returned.
   * @return the object value of the bean attribute
   *
   * @throws PropertyNotFoundException indicates the the given property
   *         could not be found on the bean
   * @throws NoSuchMethodException Not thrown
   * @throws InvocationTargetException if a specified getter method throws an
   *   exception.
   * @throws IllegalAccessException if a getter method is
   *   not public or property is write-only.
   */
  public static Map<String, Object> getObjectAttributes(Object bean, Set<String> propertyNames)
      throws
          NoSuchMethodException,
          InvocationTargetException,
          IllegalAccessException {
  	
  	Map<String, Object> objectAttributeMap = ListUtility.createMap();
      Object result = null;

      Class<?> beanClass = bean.getClass();

      PropertyDescriptor propertyDescriptor = null;

      Method readMethod = null;

      // Run through the tokens, calling get methods and
      // replacing result with the new object each time.
      // If the result equals null, then simply return null.
      for (String currentPropertyName :propertyNames){
        propertyDescriptor = getPropertyDescriptor(currentPropertyName, beanClass);

        readMethod = propertyDescriptor.getReadMethod();
        if (readMethod == null) {
            throw new IllegalAccessException(
                "User is attempting to "
                    + "read from a property that has no read method.  "
                    + " This is likely a write-only bean property.  Caused "
                    + "by property ["
                    + currentPropertyName
                    + "] on class ["
                    + beanClass
                    + "]");
        }

        result = readMethod.invoke(bean, NO_ARGUMENTS_ARRAY);
        objectAttributeMap.put(currentPropertyName, result);
      }

      return objectAttributeMap;
  }

  /**
   * <p>Sets the specified attribute on the specified object.  For example,
   * <code>getObjectAttribute(o, "address.line1", value)</code> will call
   * <code>o.getAddress().setLine1(value)</code>.<p>
   *
   * <p>The attribute specified may contain as many levels as you like. If at
   * any time a null reference is acquired by calling one of the successive
   * getter methods, then a <code>NullPointerException</code> is thrown.</p>
   *
   * @param bean the bean to call the getters on
   * @param propertyNames the name of the attribute(s) to set.  If this is
   *        null or the empty string, then an exception is thrown.
   * @param value the value of the object to set on the bean property
   *
   * @throws PropertyNotFoundException indicates the the given property
   *         could not be found on the bean
   * @throws IllegalArgumentException if the supplied parameter is not of
   *   a valid type
   * @throws NoSuchMethodException never
   * @throws IllegalAccessException if a getter or setter method is
   *   not public or property is read-only.
   * @throws InvocationTargetException if a specified getter method throws an
   *   exception.
   */
  public static void setObjectAttribute(
      Object bean,
      String propertyNames,
      Object value)
      throws
          IllegalAccessException,
          IllegalArgumentException,
          InvocationTargetException,
          NoSuchMethodException {


      Object result = bean;
      String propertyName = propertyNames;

      // Check if this has some embedded properties.  If it does, use the
      // getObjectAttribute to get the proper object to call this on.
      int indexOfLastPropertySeparator =
          propertyName.lastIndexOf(PROPERTY_SEPARATOR);

      if (indexOfLastPropertySeparator >= 0) {
          String embeddedProperties =
              propertyName.substring(0, indexOfLastPropertySeparator);

          // Grab the final property name after the last property separator
          propertyName =
              propertyName.substring(
                  indexOfLastPropertySeparator + PROPERTY_SEPARATOR.length());

          result = getObjectAttribute(result, embeddedProperties);
      }

      Class<?> resultClass = result.getClass();

      PropertyDescriptor propertyDescriptor =
          getPropertyDescriptor(propertyName, resultClass);

      Method writeMethod = propertyDescriptor.getWriteMethod();
      if (writeMethod == null) {
          throw new IllegalAccessException(
              "User is attempting to write "
                  + "to a property that has no write method.  This is likely "
                  + "a read-only bean property.  Caused by property ["
                  + propertyName
                  + "] on class ["
                  + resultClass
                  + "]");
      }

      writeMethod.invoke(result, new Object[] { value });
  }

  /**
   * Retreives a property descriptor object for a given property.
   * <p>
   * Uses the classes in <code>java.beans</code> to get back
   * a descriptor for a property.  Read-only and write-only
   * properties will have a slower return time.
   * </p>
   *
   * @param propertyName The programmatic name of the property
   * @param beanClass The Class object for the target bean.
   *                  For example sun.beans.OurButton.class.
   * @return a PropertyDescriptor for a property that follows the
   *         standard Java naming conventions.
   * @throws PropertyNotFoundException indicates that the property
   *         could not be found on the bean class.
   */
  private static final PropertyDescriptor getPropertyDescriptor(String propertyName, Class<?> beanClass) {
    BeanInfo beanInfo = null;

    PropertyDescriptor[] propertyDescriptors = null;

      PropertyDescriptor resultPropertyDescriptor = null;

      char[] pNameArray = propertyName.toCharArray();
      pNameArray[0] = Character.toLowerCase(pNameArray[0]);
      propertyName = new String(pNameArray);

      try {
          resultPropertyDescriptor = new PropertyDescriptor(propertyName, beanClass);
      } catch (IntrospectionException e1) {
          // Read-only and write-only properties will throw this
          // exception.  The properties must be looked up using
          // brute force.

          // This will get the list of all properties and iterate
          // through looking for one that matches the property
          // name passed into the method.
          try {
              beanInfo = Introspector.getBeanInfo(beanClass);

              propertyDescriptors = beanInfo.getPropertyDescriptors();

              for (int i = 0; i < propertyDescriptors.length; i++) {
                  if (propertyDescriptors[i]
                      .getName()
                      .equals(propertyName)) {

                      // If the names match, this this describes the
                      // property being searched for.  Break out of
                      // the iteration.
                      resultPropertyDescriptor = propertyDescriptors[i];
                      break;
                  }
              }
          } catch (IntrospectionException e2) {
				e2.printStackTrace();
              //log.error(e2.getMessage(), e2);
          }
      }

      // If no property descriptor was found, then this bean does not
      // have a property matching the name passed in.
      if (resultPropertyDescriptor == null) {
      	//log.info("resultPropertyDescriptor == null");
      }

      return resultPropertyDescriptor;
  }

  public static Object invokeOperation(Object bean, String methodName, Map<?, ?> params, String packagePrefix) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
  	Class<?> beanClass = bean.getClass();
  	Class<?>[] beanClasses = getInterfaces(beanClass, packagePrefix);

  	//final int paramSize = params.keySet().size();
  	//Class<?> paramClassTypes[] = new Class[paramSize];
		Class<?>[] parameterTypes = new Class<?>[params.size()];
  	Object[] parameters = new Object[params.size()];
  	int idx = 0;
  	//Method theMethod = null;
  	for (Object key :params.keySet()) {
  		parameters[idx] = params.get(key);
  		parameterTypes[idx++] = key.getClass();
  	}
  	//theMethod = beanClass.getDeclaredMethod(methodName, new Class[] {});
  	//theMethod = beanClass.getDeclaredMethod(methodName, paramClassTypes);

  	Method expectedMethod = null;
  	//Method[] methods = null;
  	for (Class<?> currBeanClass :beanClasses) {
 			expectedMethod = currBeanClass.getMethod(methodName, parameterTypes);
 			if (null != expectedMethod)
 				break;
  	}

		/*declaredMethods = beanClass.getDeclaredMethods(); 
		for (Method method :declaredMethods) { 
			if (methodName.equals(method.getName())) { 
				theMethod = method; 
				break; 
			} 
		}*/

		if (null==expectedMethod)
			return null;

  	return expectedMethod.invoke(bean, parameters);
  }

  private static Class<?>[] getInterfaces(Class<?> c, String packagePrefix) {
    List<Class<?>> result = ListUtility.createDataList();
    Class<?> processingClass = c;
    if (processingClass.isInterface()) {
        result.add(processingClass);
    } else {
        do {
            addInterfaces(processingClass, result);
            processingClass = processingClass.getSuperclass();
        } while (processingClass != null);
    }
    for (int i = 0; i < result.size(); ++i) {
        addInterfaces(result.get(i), result);
    }

    List<Class<?>> finalResults = ListUtility.createDataList();
    for (Class<?> classInstance :result) {
    	if (classInstance.getCanonicalName().startsWith(packagePrefix)) {
    		finalResults.add(classInstance);
    	}
    }

    return finalResults.toArray(new Class<?>[finalResults.size()]);
  }
  
  private static void addInterfaces(Class<?> c, List<Class<?>> list) {
      for (Class<?> intf: c.getInterfaces()) {
          if (!list.contains(intf)) {
              list.add(intf);
          }
      }
  }

  public static Object callMethod(Object bean, String methodName, Map<?, ?> params, String packagePrefix) throws ExecutionContextException {
  	try {
			return invokeOperation(bean, methodName, params, packagePrefix);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			throw new ExecutionContextException(e);
		}
  }

  public static Object clone(final Object source) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
  	return BeanUtils.cloneBean(source);
  	//return SerializationUtils.clone((Serializable) source);
  }
  
  /**
   * Sets a field value on a given object
   *
   * @param targetObject the object to set the field value on
   * @param propName    exact name of the field
   * @param propValue   value to set on the field
   * @return true if the value was successfully set, false otherwise
   */
  public static boolean setBeanProperty(Object targetObject, String propName, Object propValue) {
      Field field = null;
      try {
          field = targetObject.getClass().getDeclaredField(propName);
      } catch (NoSuchFieldException e) {
          field = null;
      }

      Class<?> superClass = targetObject.getClass().getSuperclass();
      while (field == null && superClass != null) {
          try {
              field = superClass.getDeclaredField(propName);
          } catch (NoSuchFieldException e) {
              superClass = superClass.getSuperclass();
          }
      }

      if (field == null) {
          return false;
      }

      field.setAccessible(true);
      try {
          field.set(targetObject, propValue);
          return true;
      } catch (IllegalAccessException e) {
          return false;
      }
  }

  public static List<String> getBeanPropertyNames(Object bean){
  	List<String> beanPropertyNames = ListUtility.createList();
  	List<Field> fieldList = getInheritedPrivateFields(bean.getClass());

  	fieldList.forEach(field->{
      if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
    		beanPropertyNames.add(field.getName());
      }
  	});
  	return beanPropertyNames;
  }

  private static List<Field> getInheritedPrivateFields(Class<?> type) {
    List<Field> result = ListUtility.createList();

    Class<?> i = type;
    while (i != null && i != Object.class) {
        Collections.addAll(result, i.getDeclaredFields());
        i = i.getSuperclass();
    }

    return result;
  }

  public static Object copyBean(final Object source, Object target) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
  	Object propVal = null;
  	List<String> propertyNames = getBeanPropertyNames(target);
		copyProperties(source, target);
  	/*for (String property :propertyNames) {
  		try {
    		propVal = getBeanProperty(source, property);
			} catch (Exception e) {
				propVal = null;
				// TODO: handle exception
			}
  		setBeanProperty(target, property, propVal);
  	}*/
  	return target;
  }

  public static void copyProperties(Object fromObj, Object toObj) {
    Class<? extends Object> fromClass = fromObj.getClass();
    Class<? extends Object> toClass = toObj.getClass();

    try {
        BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
        BeanInfo toBean = Introspector.getBeanInfo(toClass);

        PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
        List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());
        PropertyDescriptor pd = null;
        for (PropertyDescriptor propertyDescriptor : toPd) {
            if (propertyDescriptor.getDisplayName().equalsIgnoreCase("class"))
            	continue;

            for(PropertyDescriptor fromPropertyDescriptor :fromPd){
            	if (!fromPropertyDescriptor.getName().equals(propertyDescriptor.getName()))
            		continue;
            	
              if(propertyDescriptor.getWriteMethod() != null) {
                propertyDescriptor.getWriteMethod().invoke(toObj, fromPropertyDescriptor.getReadMethod().invoke(fromObj, null));
              }
          		break;
            }
            /*try {
            	
              pd = fromPd.get(fromPd.indexOf(propertyDescriptor));
						} catch (Exception e) {
							pd = null;
						}

            if (null == pd)
            	continue;

            if (pd.getDisplayName().equals(propertyDescriptor.getDisplayName()) && !pd.getDisplayName().equals("class")) {
                 if(propertyDescriptor.getWriteMethod() != null) {
                         propertyDescriptor.getWriteMethod().invoke(toObj, pd.getReadMethod().invoke(fromObj, null));
                 }
            }*/
        }
    } catch (IntrospectionException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }  
}
