package com.builder.template

public class Principal {

    def multislect() {
        def html = '<table>'
        html += '<tbody>'
        html += '<tr>'
        html += '<td>'
        html += '</td>'
        html += '</tr>'
        html += '</tbody>'
        html += '</table>'
    }

    def select(data) {
        def html = '<slect multiple>'
        data.each { item->
            html += '<option>' + item + '</option>'
        }
        html += '</select>'

        return html
    }

}
