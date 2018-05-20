package com.parking.parkingservices.repository.base;

import java.io.IOException;

import com.parking.parkingservices.repository.ConsultaNitMovimientoReportReposity;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public abstract class ReportRepositoryBase implements IReportRepository {

    private final String BASE_NAME = "getQuery";

    @PersistenceContext
    private EntityManager em;

    private String getPreQuery() {
        Class<?> clazz = this.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(BASE_NAME) && method.isAnnotationPresent(Query.class)) {
                String value = method.getAnnotation(Query.class).value();
                if (value.isEmpty()){
                    try {
                        String file = method.getAnnotation(Query.class).file();
                        URL url = ConsultaNitMovimientoReportReposity.class.getResource(file);
                        value = new String ( Files.readAllBytes( Paths.get(url.getPath()) ) );
                    } catch (IOException ex) {
                    }
                }
                return value;
            }
        }
        return "";
    }

    @Override
    public List getReport(HashMap<String, String> params) {
        String preQuery = getPreQuery();
        if (params.containsKey("__params__")){
            return getParams(preQuery);
        }

        String query = getQuery(preQuery, params);
        for (String paramName : params.keySet()) {
            //remplazamos valores sin comillas
            query = query.replaceAll("::" + paramName, params.get(paramName));
        }
        String forprint = query;
        for (String paramName : params.keySet()) {
            //remplazamos valores con comillas
            forprint = forprint.replaceAll(":" + paramName, "'" + params.get(paramName) + "'");
        }
        
        forprint = forprint.replaceAll(":\\w+", "''");

        System.out.println(forprint);
        javax.persistence.Query nativeQuery = em.createNativeQuery(forprint);

        //toma los parametros que contiene la query
        Set<Parameter<?>> parameters = nativeQuery.getParameters();
        //por cada parametro
        parameters.forEach((parameter) -> {
            //le asigna el valor correspondiente segun HashMap de paramtros definido
            nativeQuery.setParameter(parameter.getName(), params.get(parameter.getName()));
        });
        org.hibernate.Query hibernateQuery = ((org.hibernate.jpa.HibernateQuery) nativeQuery).getHibernateQuery();
        hibernateQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List result = nativeQuery.getResultList();

        return result;
    }

    public List<String> getParams(String query) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(":+\\w+");
        Matcher m = pattern.matcher(query);
        while (m.find()) {
            String s = m.group();
            if (!s.contains("::") && !list.contains(s.replace(":", ""))){
                list.add(s.replace(":", ""));
            }
        }
        return list;
    }

    public abstract String getQuery(String query, HashMap<String, String> params);

}
