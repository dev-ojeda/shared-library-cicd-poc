#!/usr/bin/env groovy

package com.builder.util

public class Mock {

    def listTipo() {
        def listaTipo = ["\"Seleccione:selected\"", "\"dprep\"", "\"purp\""] as LinkedList
        return buildScript(listaTipo)
    }

    def listGeo() {
        def listaGeo = ["\"Seleccione:selected\"", "\"AR\"", "\"CL\""] as LinkedList
        return buildScript(listaGeo)
    }

    def listDominio() {
        return listaDominio
    }

    String buildScript(LinkedList values) {
        return " return ${values} "
    }

    def populateItemsDprep(Object tipo, Object cl, Object ar) {
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

    def populateItemsPurp(Object tipo, Object cl, Object ar) {
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

    def listaDominioPorGeo(Object tipo, Object geo) {
        def resultado = []
        def listaDominioCLDprep = ["\"DMCLDPREP1\"", "\"DMCLDPREP2\""] as LinkedList
        def listaDominioARDprep = ["\"DMARDPREP1\"", "\"DMARDPREP2\""] as LinkedList
        def listaDominioCLPurp = ["\"DMCLPURP1\"", "\"DMCLPURP2\""] as LinkedList
        def listaDominioARPurp = ["\"DMARPURP1\"", "\"DMARPURP2\""] as LinkedList
        if (tipo == 'dprep' || geo == 'CL' || geo == 'AR') {
            resultado = populateItemsDprep(tipo, listaDominioCLDprep, listaDominioARDprep)
        }
        else if (tipo == 'purp' || geo == 'CL' || geo == 'AR') {
            resultado = populateItemsPurp(tipo, listaDominioCLPurp, listaDominioARPurp)
        }
        else if (tipo == 'Selecione' && geo == 'Seleccione'){
            resultado += populateItemsDprep(tipo, listaDominioCLDprep, listaDominioARDprep)
            resultado += populateItemsPurp(tipo, listaDominioCLPurp, listaDominioARPurp)
        }
        return resultado
    }

}