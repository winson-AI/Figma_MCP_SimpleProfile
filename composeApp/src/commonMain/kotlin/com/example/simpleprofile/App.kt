package com.example.simpleprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import simpleprofile.composeapp.generated.resources.Res
import simpleprofile.composeapp.generated.resources.*

@Composable
@Preview
fun App() {
    UserProfileScreen()
}

@Composable
fun UserProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFF2A9D), // #ff2a9d
                        Color(0xFFF72A6F), // #f72a6f
                        Color(0xFFF32A52), // #f32a52
                        Color(0xFFEF2A39)  // #ef2a39
                    ),
                    center = androidx.compose.ui.geometry.Offset(0.5f, 0.4f),
                    radius = 400f
                )
            )
    ) {
        // Background pattern images
        Image(
            painter = painterResource(Res.drawable.img_background_pattern),
            contentDescription = null,
            modifier = Modifier
                .size(196.dp)
                .offset(x = (-96).dp, y = 11.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.9f
        )

        Image(
            painter = painterResource(Res.drawable.img_background_pattern),
            contentDescription = null,
            modifier = Modifier
                .size(196.dp)
                .offset(x = 324.dp, y = 11.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.9f
        )

        // Navigation icons
        IconButton(
            onClick = { /* Handle back navigation */ },
            modifier = Modifier
                .offset(x = 15.dp, y = 26.dp)
                .size(28.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_left),
                contentDescription = "Back",
                tint = Color.White
            )
        }

        IconButton(
            onClick = { /* Handle settings */ },
            modifier = Modifier
                .offset(x = 386.dp, y = 28.dp)
                .size(24.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_settings),
                contentDescription = "Settings",
                tint = Color.White
            )
        }

        // Main content card
        Card(
            modifier = Modifier
                .offset(y = 161.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 17.dp)
            ) {
                Spacer(modifier = Modifier.height(107.dp))

                // Profile sections
                ProfileSection(
                    label = "Name",
                    value = "Sophia Patel"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileSection(
                    label = "Email",
                    value = "sophiapatel@gmail.com"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileSection(
                    label = "Delivery address",
                    value = "123 Main St Apartment 4A,\nNew York, NY"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileSection(
                    label = "Password",
                    value = "••••••••••••",
                    showLockIcon = true
                )

                Spacer(modifier = Modifier.height(23.dp))

                // Separator line
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray.copy(alpha = 0.5f))
                        .offset(y = (-1).dp)
                )

                Spacer(modifier = Modifier.height(33.dp))

                // Menu items
                MenuItem(
                    text = "Payment Details",
                    onClick = { /* Handle payment details */ }
                )

                Spacer(modifier = Modifier.height(28.dp))

                MenuItem(
                    text = "Order history",
                    onClick = { /* Handle order history */ }
                )

                // Spacer to position bottom buttons correctly
                Spacer(modifier = Modifier.height(20.dp)) // Position buttons at correct Figma coordinates

                // Bottom action buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    horizontalArrangement = Arrangement.spacedBy(17.dp)
                ) {
                    ActionButton(
                        text = "Edit Profile",
                        onClick = { /* Handle edit profile */ },
                        modifier = Modifier.weight(1f)
                    )

                    ActionButton(
                        text = "Log out",
                        onClick = { /* Handle logout */ },
                        modifier = Modifier.weight(1f),
                        isOutlined = true
                    )
                }
            }
        }

        // Profile avatar
        Box(
            modifier = Modifier
                .offset(x = 146.dp, y = 68.dp)
                .size(139.dp)
                .background(Color(0xFFD9D9D9), RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(Res.drawable.img_profile_avatar),
                contentDescription = "Profile Avatar",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            // Red border
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent, RoundedCornerShape(24.dp))
                    .border(BorderStroke(4.dp, Color(0xFFEF2A39)), RoundedCornerShape(24.dp))
            )
        }
    }
}

@Composable
fun ProfileSection(
    label: String,
    value: String,
    showLockIcon: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(71.dp)
    ) {
        // Background container with cut-out effect
        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = 11.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White, RoundedCornerShape(10.dp))
                .border(BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.3f)), RoundedCornerShape(10.dp))
        )

        // Label background cut-out
        Box(
            modifier = Modifier
                .offset(x = 22.dp, y = 0.dp)
                .width(55.dp)
                .height(22.dp)
                .background(Color(0xFFE8E8E8)) // Match parent background color
        ){
            Text(
                text = label,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                modifier = Modifier.offset(x = 29.dp, y = 0.dp)
            )

            if (showLockIcon) {
                Icon(
                    painter = painterResource(Res.drawable.ic_lock),
                    contentDescription = "Lock",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(11.dp))
            }
        }

        // Value text positioned inside container
        Row(
            modifier = Modifier
                .offset(x = 39.dp, y = 31.dp)
                .width(356.dp), // 395 - 39 = 356 (container width minus left offset)
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3C2F2F),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun MenuItem(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 46.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Icon(
            painter = painterResource(Res.drawable.ic_chevron_right),
            contentDescription = "Chevron Right",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
    }
}

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isOutlined: Boolean = false
) {
    val containerColor = if (isOutlined) Color.Transparent else Color(0xFF3C2F2F)
    val contentColor = if (isOutlined) Color(0xFFEF2A39) else Color.White
    val borderColor = if (isOutlined) Color(0xFFEF2A39) else Color.Transparent

    Button(
        onClick = onClick,
        modifier = modifier
            .height(70.dp)
            .border(
                BorderStroke(
                    width = if (isOutlined) 3.dp else 0.dp,
                    color = borderColor
                ),
                shape = RoundedCornerShape(20.dp)
            ),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 9.dp,
            pressedElevation = 6.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (!isOutlined) {
                Icon(
                    painter = painterResource(Res.drawable.ic_edit_combined),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            if (isOutlined) {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(Res.drawable.ic_signout_combined),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}