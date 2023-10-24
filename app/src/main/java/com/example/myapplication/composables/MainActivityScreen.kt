package com.example.myapplication.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.MainViewModel
import com.example.myapplication.data.models.SharedMetadata


@Composable
fun MainScreen(mainViewModel: MainViewModel) {

    return Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        val sharedMetadata by mainViewModel.getMetadataFlow.collectAsState(
            initial = null
        )

        Column {
            TopBar()
            sharedMetadata?.let { MetadataViewer(it) }
        }
    }
}

@Composable
fun MetadataViewer(metadata: SharedMetadata, modifier: Modifier = Modifier) {
    Text(
        text = metadata.userId,
        modifier = modifier
    )
}

@Composable
fun TopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {

        followedUserList()
        IconButton(onClick = { }) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "Partagez"
            )
        }
    }
}

val listItems = listOf("Klara", "Mark", "Sonia", "Paul")

@Composable
fun followedUserList() {
    DropdownMenu(expanded = true, onDismissRequest = { false }) {
        listItems.forEachIndexed { itemIndex, itemValue ->
            DropdownMenuItem(
                onClick = {},
                text = { Text(text = itemValue) }
            )
        }
    }
}