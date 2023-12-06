package com.example.roomsiswa.ui.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomsiswa.R
import com.example.roomsiswa.data.Siswa
import com.example.roomsiswa.model.HomeViewModel
import com.example.roomsiswa.model.PenyediaViewModel
import com.example.roomsiswa.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {

}

@Composable
fun BodyHome(
    itemSiswa: List<Siswa>, modifier: Modifier = Modifier
) {

}

@Composable
fun ListSiswa(
    itemSiswa: List<Siswa>, modifier: Modifier = Modifier
) {
    LazyColumn(content = modifier = Modifier) {
        items(items = itemSiswa, key = { it.id }) { person ->
            DataSiswa(
                siswa = person,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun DataSiswa(
    siswa: Siswa, modifier: Modifier = Modifier
) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp))
    {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.padding_small)
            )
        ) {
            Row(modifier = Modifier.fillMaxWidth())
            {
                Text(text = siswa.nama, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.weight(1f))
                Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                Text(text = siswa.telpon, style = MaterialTheme.typography.titleMedium)
            }
            Text(text = siswa.alamat, style = MaterialTheme.typography.titleMedium)
        }
    }
}