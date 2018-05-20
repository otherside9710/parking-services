package com.parking.parkingservices.repository;

import com.parking.parkingservices.repository.base.Query;
import com.parking.parkingservices.repository.base.ReportRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ConsultaNitMovimientoReportReposity extends ReportRepositoryBase {
    @Query(value = "select\n" +
            "    ifnull(pers_nombre,'') as pers_nombre,\n" +
            "    ifnull(pers_codigo,'') as pers_codigo,\n" +
            "    ifnull(cbod_puc,'') as cbod_puc,\n" +
            "    debito,\n" +
            "    credito,\n" +
            "    ifnull(puc_nombre,'') as puc_nombre,\n" +
            "    ifnull(cbod_ccosto,'') as cbod_ccosto,\n" +
            "    ifnull(cbod_razonconcepto,'') as cbod_razonconcepto,\n" +
            "    cbod_fecha,\n" +
            "    cbod_concepto,\n" +
            "    cbod_documento,\n" +
            "    puc_NombreClase,\n" +
            "    puc_NombreGrupo,\n" +
            "    puc_NombreMayor,\n" +
            "    puc_NombreSubMayor,\n" +
            "    ccos_nombre\n" +
            "    chea_fecha,\n" +
            "    ifnull(cbod_tercero, '') as cbod_tercero,\n" +
            "    ifnull(puc_Clase,'') as puc_Clase,\n" +
            "    ifnull(puc_Grupo,'') as puc_Grupo,\n" +
            "    ifnull(puc_Mayor,'') as puc_Mayor,\n" +
            "    ifnull(puc_subMayor,'') as puc_subMayor,\n" +
            "    :Ffinicio as fecha_i,\n" +
            "    :Fffinal as fecha_f,\n" +
            "    debito - credito as valor,\n" +
            "    @saldo_anterior \\:= if (ifnull(@old_tercero, 'NULL') != ifnull(cbod_tercero, 'NULL') or ifnull(@old_puc, 'NULL') != ifnull(cbod_puc, 'NULL'), (debito - credito), if (cbod_fecha >= :Ffinicio, @saldo_anterior, @saldo_anterior + (debito - credito))) as saldo_anterior,\n" +
            "    @old_tercero \\:= cbod_tercero as old_tercero,\n" +
            "    @old_puc \\:= cbod_puc as old_puc\n" +
            "from (\n" +
            "    select\n" +
            "        ifnull(pers_codigo, '') as pers_codigo,\n" +
            "        cbod_puc,\n" +
            "        a.puc_nombre,\n" +
            "       cbod_ccosto,\n" +
            "        if(cbod_tipo='D' and cbod_estado <> 'A',cbod_valor,0) as debito,\n" +
            "       if(cbod_tipo='C' and cbod_estado not in ('a','A'), cbod_valor,0) as credito,\n" +
            "       replace(ifnull(pers_nombre,''), '|',' ') as pers_nombre,\n" +
            "       cbod_razonconcepto,\n" +
            "        cbod_fecha,\n" +
            "        cbod_concepto,\n" +
            "        cbod_tercero,\n" +
            "        cbod_documento,\n" +
            "       ifnull(b.puc_codigo,'') as puc_Clase,ifnull(b.puc_nombre,'') as puc_NombreClase,\n" +
            "       ifnull(c.puc_codigo,'') as puc_Grupo,ifnull(b.puc_nombre,'') as puc_NombreGrupo,\n" +
            "       ifnull(d.puc_codigo,'') as puc_Mayor,ifnull(d.puc_nombre,'') as puc_NombreMayor,\n" +
            "       ifnull(e.puc_codigo,'') as puc_subMayor,ifnull(e.puc_nombre,'') as puc_NombreSubMayor,\n" +
            "       ccos_nombre,\n" +
            "        chea_fecha,\n" +
            "       if(:Wniif=0 OR :Wniif = '','LOCAL','NIIF') as normatividad,\n" +
            "       @saldo_anterior \\:= 0 as reset_saldo,\n" +
            "       docu_interfazniif\n" +
            "    from myacbodymovimientos as dt\n" +
            "      left join myacdocumentos on docu_codigo=cbod_concepto\n" +
            "      left join myacheadmovimientos on chea_ccosto=dt.cbod_bodega and chea_documento=dt.cbod_documento and chea_concepto=dt.cbod_concepto\n" +
            "      left join myaccosto on ccos_codigo=cbod_ccosto\n" +
            "      left join myagpersonas on pers_codigo=cbod_tercero\n" +
            "      left join myacpuc::Waddniif a on a.puc_codigo=cbod_puc                # Auxiliar\n" +
            "      left join myacpuc::Waddniif b on b.puc_codigo=substring(cbod_puc,1,1) # Clase\n" +
            "      left join myacpuc::Waddniif c on c.puc_codigo=substring(cbod_puc,1,2) # Grupo\n" +
            "      left join myacpuc::Waddniif d on d.puc_codigo=substring(cbod_puc,1,4) # Mayor\n" +
            "      left join myacpuc::Waddniif e on e.puc_codigo=substring(cbod_puc,1,6) # Submayor\n" +
            "      where chea_fecha <= :Fffinal\n" +
            ") as rs\n" +
            "\n" +
            "where chea_fecha between :Ffinicio and :Fffinal ::Wexcept ::Wpuc ::WStrnit ::Wcadopex ::WStrOrderBy")
    /**
     * @Param Wnit
     * @Param Ffinicio
     * @Param Fffinal
     * @Param Wccosto
     * @Param Wsubccosto
     * @Param Wniif
     */
    @Override
    public String getQuery(String query, HashMap<String, String> params) {
        String WStrnit = "";
        String Wpuc = "";
        String Wcadopex="";
        String Waddniif = "";
        String Wcampofecha="";
        String Wcampofechas="";
        String Wexcept = " ";
        String WStrOrderBy;

        if (params.containsKey("Wnit") && !params.get("Wnit").isEmpty()) {
            WStrnit += "and cbod_tercero ='"+params.get("Wnit")+"' ";
        }

        if (params.containsKey("Wpuci")){
            Wpuc +=" and cbod_puc like '"+params.get("Wpuci").trim()+"%' ";
        }
        
        /**
         * WStrOrderBy = 
        if(!empty(thisform.myacsubccostos1.cuentaPuc.value)
            if(!empty(thisform.txtnittercero.Value)
                'order by dt.cbod_tercero,cbod_puc,cbod_fecha,cbod_documento'
            else
                ' order by cbod_puc,dt.cbod_tercero,cbod_fecha,cbod_documento'),
                ' order by dt.cbod_tercero,cbod_puc,cbod_fecha,cbod_documento'
        */
        if (params.containsKey("Wpuci")){
            if (params.containsKey("Wnit")){
                WStrOrderBy = "order by cbod_tercero,cbod_puc,cbod_fecha,cbod_documento";
            }
            else {
                WStrOrderBy = "order by cbod_puc,cbod_tercero,cbod_fecha,cbod_documento";
            }
        } else {
            WStrOrderBy = "order by cbod_tercero,cbod_puc,cbod_fecha,cbod_documento";
        }

        if(params.containsKey("Wcadcierre")){
            Wcadopex += "and cbod_ccosto ='"+params.get("Wcadcierre")+"' ";
        }

        if (params.containsKey("Wccosto")) {
            Wcadopex += " and cbod_ccosto='" + params.get("Wccosto") + "' ";
        }

        if (params.containsKey("Wsubccosto")) {
            Wcadopex += " and cbod_subccosto='" + params.get("Wsubccosto") + "' ";
        }

        if (params.containsKey("Wdependencia")) {
            Wcadopex += " and cbod_dependencia='" + params.get("Wdependencia") + "'";
        }

        if (params.containsKey("Wniif")){
            Waddniif += "niff";
            Wcampofecha +="chea_fecha";
            Wcampofechas +="chea_fecha";
        }
        else {
            Wcampofecha +="dt.cbod_fecha";
            Wcampofechas +="dts.cbod_fecha";
            Wexcept = "and docu_interfazniif!='S'";
            params.put("Wniif", "");
        }

        params.put("WStrnit",WStrnit);
        params.put("Wpuc",Wpuc);
        params.put("Wcadopex",Wcadopex);
        params.put("Waddniif",Waddniif);
        params.put("Wcampofecha",Wcampofecha);
        params.put("Wcampofechas",Wcampofechas);
        params.put("Wexcept",Wexcept);
        params.put("WStrOrderBy",WStrOrderBy);
        
        return query;
    }
}
