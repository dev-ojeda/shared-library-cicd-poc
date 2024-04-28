#!/usr/bin/env groovy

package com.builder.util

public class Mock {

    static def lista_tipo() {
        def listaTipo = new String[] {"\"Seleccione:selected\"", "\"dprep\"", "\"purp\""}
        return build_cript(listaTipo)
    }

    static def lista_geo() {
        def listaGeo = new String[] {"\"Seleccione:selected\"", "\"AR\"", "\"CL\""}
        return build_cript(listaGeo)
    }

    // static def lista_dominio() {
    //     return listaDominio
    // }

    static String build_cript(LinkedList values) {
        return " return ${values} "
    }

    static def populate_items_dprep(Object tipo, Object cl, Object ar) {
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

    static def populate_items_purp(Object tipo, Object cl, Object ar) {
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
        def listaDominioCLDprep = ["\"DMCLDPREP1\"", "\"DMCLDPREP2\""] as LinkedList
        def listaDominioARDprep = ["\"DMARDPREP1\"", "\"DMARDPREP2\""] as LinkedList
        def listaDominioCLPurp = ["\"DMCLPURP1\"", "\"DMCLPURP2\""] as LinkedList
        def listaDominioARPurp = ["\"DMARPURP1\"", "\"DMARPURP2\""] as LinkedList
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