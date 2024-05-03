#!/usr/bin/env groovy

package com.builder.util

public class Mock {

    static String lista_tipo() {
        def listaTipo = ["\"Seleccione:selected\"", "\"dprep\"", "\"purp\""]
        return build_script(listaTipo)
    }

    static String lista_geo() {
        def listaGeo = ["\"Seleccione:selected\"", "\"AR\"", "\"CL\""]
        return build_script(listaGeo)
    }

    // static def lista_dominio() {
    //     return listaDominio
    // }

    public static String build_script(def values) {
        return " return ${values} "
    }

    public static String populate_items_dprep(Object tipo, Object cl, Object ar) {
        return '''if(Geos.equals('CL') && Tipo.equals("${tipo}")){
            return $cl
        }
        else if(Geos.equals('AR') && Tipo.equals("$tipo")){
            return $ar
        }
        else if(Geos.equals('Seleccione') && Tipo.equals('Seleccione')){
            return $listaDominio
        }
        '''
    }

    public static String populate_items_purp(Object tipo, Object cl, Object ar) {
        return '''if(Geos.equals('CL') && Tipo.equals("$tipo")){
            return $cl
        }
        else if(Geos.equals('AR') && Tipo.equals("$tipo")){
            return $ar
        }
        else if(Geos.equals('Seleccione') && Tipo.equals('Seleccione')){
            return $listaDominio
        }
        '''
    }

    static def lista_dominio_por_geo(Object tipo, Object geo) {
        def resultado = []
        def listaDominioCLDprep = ["\"DMCLDPREP1\"", "\"DMCLDPREP2\""]
        def listaDominioARDprep = ["\"DMARDPREP1\"", "\"DMARDPREP2\""]
        def listaDominioCLPurp = ["\"DMCLPURP1\"", "\"DMCLPURP2\""]
        def listaDominioARPurp = ["\"DMARPURP1\"", "\"DMARPURP2\""]
        if (tipo == 'dprep' || geo == 'CL' || geo == 'AR') {
            resultado = populate_items_dprep(tipo, listaDominioCLDprep, listaDominioARDprep)
        }
        else if (tipo == 'purp' || geo == 'CL' || geo == 'AR') {
            resultado = populate_items_purp(tipo, listaDominioCLPurp, listaDominioARPurp)
        }
        else if (tipo == 'Selecione' && geo == 'Seleccione'){
            resultado += populate_items_dprep(tipo, listaDominioCLDprep, listaDominioARDprep)
            resultado += populate_items_purp(tipo, listaDominioCLPurp, listaDominioARPurp)
        }
        return resultado
    }

}