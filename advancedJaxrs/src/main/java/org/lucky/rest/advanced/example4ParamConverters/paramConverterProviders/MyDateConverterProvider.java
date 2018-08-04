package org.lucky.rest.advanced.example4ParamConverters.paramConverterProviders;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import org.lucky.rest.advanced.example4ParamConverters.model.MyDate;

/**
 * 
 * ParamConverter is created as anonymous inner class
 *
 */
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType,
			Type genericType, Annotation[] annotations) {
		//if(rawType.getName().equals(MyDate.class.getName())){
		if(MyDate.class.isAssignableFrom(rawType)){
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					// TODO Auto-generated method stub
					MyDate myDate = new MyDate();
					String []a = value.split("-");
					myDate.setDate(Integer.parseInt(a[0]));
					myDate.setMonth(Integer.parseInt(a[1]));
					myDate.setYear(Integer.parseInt(a[2]));
					//return (T) myDate;
					return rawType.cast(myDate); // make sure rawType is declared final
				}

				@Override
				public String toString(T value) {
					if (value == null)
						return null;
					// TODO Auto-generated method stub
					return value.toString();
				}
			};
		}
		return null;
	}

}
