package com.jebcosta.apphackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.jebcosta.apphackathon.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaEstados = arrayListOf("Estado",
                "Acre (AC)", // 1
                "Alagoas (AL)",  // 2
                "Amapá (AP)", // 3
                "Amazonas (AM)", // 4
                "Bahia (BA)", // 5
                "Ceará (CE)", // 6
                "Distrito Federal (DF)", // 7
                "Espírito Santo (ES)", // 8
                "Goiás (GO)", // 9
                "Maranhão (MA)", // 10
                "Mato Grosso (MT)", // 11
                "Mato Grosso do Sul (MS)", // 12
                "Minas Gerais (MG)", // 13
                "Pará (PA)", // 14
                "Paraíba (PB)", // 15
                "Paraná (PR)", // 16
                "Pernambuco (PE)", // 17
                "Piauí (PI)", // 18
                "Rio de Janeiro (RJ)", // 19
                "Rio Grande do Norte (RN)", // 20
                "Rio Grande do Sul (RS)", // 21
                "Rondônia (RO)", // 22
                "Roraima (RR)", // 23
                "Santa Catarina (SC)", // 24
                "São Paulo (SP)", // 25
                "Sergipe (SE)", // 26
                "Tocantins (TO)" // 27
        )

        val spinnerAdapter = ArrayAdapter(
            this,
            R.layout.layout_branco_item,
            listaEstados
        )
        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

        binding.spnMainEstado.adapter = spinnerAdapter

        //
        binding.btnMainCalcular.setOnClickListener {

            val valor = binding.edtMainValor.text.toString().trim()
            val estado = binding.spnMainEstado.selectedItem.toString()

            if (valor.isEmpty()) {
                Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else if (estado == listaEstados[0]){
                Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG).show()

            // Valor 2.5%
            } else if (estado == listaEstados[2] || estado == listaEstados[17] ||
                        estado == listaEstados[20] || estado == listaEstados[6]||
                        estado == listaEstados[18] || estado == listaEstados[10] ||
                        estado == listaEstados[5] || estado == listaEstados[21] ||
                        estado == listaEstados[12] || estado == listaEstados[9]){
                val ipva = (valor.toBigDecimal() * 2.50.toBigDecimal()) / 100.00.toBigDecimal()
                binding.txtMainResultado.text = ("O valor do IPVA é: R$ %.2f".format(ipva))
            // Valor 2.0%
            } else if (estado == listaEstados[1] || estado == listaEstados[27] ||
                        estado == listaEstados[8] || estado == listaEstados[24] ||
                        estado == listaEstados[26] || estado == listaEstados[15]){
                val ipva = (valor.toBigDecimal() * 2.00.toBigDecimal()) / 100.00.toBigDecimal()
                binding.txtMainResultado.text = ("O valor do IPVA é: R$ %.2f".format(ipva))
            // Valor 3.5%
            } else if (estado == listaEstados[16]){
                val ipva = (valor.toBigDecimal() * 3.50.toBigDecimal()) / 100.00.toBigDecimal()
                binding.txtMainResultado.text = ("O valor do IPVA é: R$ %.2f".format(ipva))
            // Valor 3.0%
            } else if (estado == listaEstados[21] || estado == listaEstados[11] ||
                estado == listaEstados[7] || estado == listaEstados[25]||
                estado == listaEstados[3] || estado == listaEstados[4] ||
                estado == listaEstados[22] || estado == listaEstados[23]) {
                val ipva = (valor.toBigDecimal() * 3.00.toBigDecimal()) / 100.00.toBigDecimal()
                binding.txtMainResultado.text = ("O valor do IPVA é: R$ %.2f".format(ipva))
            // Valor 4.0%
            } else if (estado == listaEstados[19] || estado == listaEstados[13]){
                val ipva = (valor.toBigDecimal() * 4.00.toBigDecimal()) / 100.00.toBigDecimal()
                binding.txtMainResultado.text = ("O valor do IPVA é: R$ %.2f".format(ipva))
            }
        }
    }
}
