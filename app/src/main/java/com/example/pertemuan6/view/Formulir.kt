package com.example.pertemuan6.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.pertemuan6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var textNama by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                label = { Text(stringResource(id = R.string.nama_lengkap)) },
                onValueChange = { textNama = it }
            )

            Text(
                text = stringResource(id = R.string.jenis_kelamin),
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
            )
            Row {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = false,
                            onClick = { item }
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            OutlinedTextField(
                value = "",
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                label = { Text(stringResource(id = R.string.alamat)) },
                onValueChange = { }
            )


            Button(
                modifier = Modifier.fillMaxWidth(0.8f),
                enabled = textAlamat.isNotEmpty(),
                onClick = { OnSubmitBtnClick(textNama, textJK, textAlamat) }
            ) {
                Text(stringResource(id = R.string.submit))
            }
        }
    }
}