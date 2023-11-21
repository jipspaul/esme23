package com.example.myapplication.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.MainViewModel
import com.example.myapplication.data.UserRepository
import com.example.myapplication.data.models.SharedMetadata
import com.example.myapplication.data.models.User
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState


@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    onStartSharing: () -> Unit,
    onStartScan: () -> Unit,
    userRepository: UserRepository
) {

    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }

    return Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        val sharedMetadata by mainViewModel.sharedMetaData.collectAsState(
            initial = null
        )

        val listUser by userRepository.getFollowedUser().collectAsState(
            initial = listOf()
        )

        if (sharedMetadata != null && sharedMetadata?.location?.lat != null && sharedMetadata?.location?.long != null) {
            cameraPositionState.position = CameraPosition.fromLatLngZoom(
                LatLng(
                    sharedMetadata?.location?.lat!!,
                    sharedMetadata?.location?.long!!
                ), 30f
            )
        }

        Column {
            TopBar(onStartSharing, { mainViewModel.selectUser(it) }, onStartScan, listUser)

            sharedMetadata?.let {
                MetadataViewer(it)
            }

            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                cameraPositionState = cameraPositionState
            ) {
                sharedMetadata?.let {
                    Marker(
                        state = rememberMarkerState(
                            position = LatLng(
                                it.location.lat,
                                it.location.long
                            )
                        ),
                        title = "${sharedMetadata?.userId}",
                        snippet = "SAFE PLACE",
                        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
                    )
                }
            }

        }
    }
}

@Composable
fun MetadataViewer(metadata: SharedMetadata, modifier: Modifier = Modifier) {

    Card {
        Column {
            Text(
                text = "User Id :${metadata.userId}",
                modifier = modifier
            )

            Text(
                text = "Phone Number : ${metadata.privateData?.phoneNumber}",
                modifier = modifier
            )
            Text(
                text = "Is on a Safe place : ",
                modifier = modifier
            )
            Text(
                text = "Battery Status :  ${metadata.batteryStatus.percentageValue}",
                modifier = modifier
            )
        }
    }
}

@Composable
fun TopBar(
    onClick: () -> Unit,
    onUserSelect: (String) -> Unit,
    onScanButtonClick: () -> Unit,
    list: List<User>
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        followedUserList(list, onUserSelect)
        IconButton(onClick = onClick) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "Partagez"
            )
        }
        IconButton(onClick = onScanButtonClick) {
            Icon(
                // camera icon
                Icons.Filled.AddCircle,
                contentDescription = "Scan"
            )
        }
    }
}

@Composable
fun followedUserList(userFollowedList: List<User>, onUserSelect: (String) -> Unit) {

    var expanded by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("Select User") }

    Box {
        Text(text = name,
            modifier = Modifier
                .clickable {
                    expanded = true
                }
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            userFollowedList.forEachIndexed { itemIndex, itemValue ->
                DropdownMenuItem(
                    onClick = {
                        onUserSelect(userFollowedList[itemIndex].id)
                        name = userFollowedList[itemIndex].firstName
                        expanded = false
                    },
                    text = { Text(text = itemValue.firstName) }
                )
            }
        }
    }
}