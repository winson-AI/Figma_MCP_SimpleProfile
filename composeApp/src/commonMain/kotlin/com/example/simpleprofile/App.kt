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
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
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
            alpha = 0.4f,
            colorFilter = ColorFilter.tint(
                color = Color(0xFFEF2A39), // 这里的颜色会影响混合效果，根据需要调整
                blendMode = BlendMode.Overlay
            )
        )

        Image(
            painter = painterResource(Res.drawable.img_background_pattern),
            contentDescription = null,
            modifier = Modifier
                .size(196.dp)
                .offset(x = 324.dp, y = 11.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.4f,
            colorFilter = ColorFilter.tint(
                color = Color(0xFFEF2A39), // 这里的颜色会影响混合效果，根据需要调整
                blendMode = BlendMode.Overlay
            )
        )

        // Navigation icons
        IconButton(
            onClick = { /* Handle back navigation */ },
            modifier = Modifier
                .offset(x = 15.dp, y = 28.dp)
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
                .align(Alignment.TopEnd)
                .padding(end = 15.dp, top = 28.dp)
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
        /* 下方白色卡片（无变动） */
        Box(
            modifier = Modifier
                .offset(y = 11.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White, RoundedCornerShape(10.dp))
                .border(
                    BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.3f)),
                    RoundedCornerShape(10.dp)
                )
        )

        /* Label 区域：背景自动伸缩 */
        Row(
            modifier = Modifier
                .offset(x = 22.dp, y = 0.dp)      // 整体左上角位置保持原设计
                .background(Color.White, RoundedCornerShape(4.dp))
                .padding(horizontal = 8.dp, vertical = 3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )

            if (showLockIcon) {
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(Res.drawable.ic_lock),
                    contentDescription = "Lock",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Gray
                )
            }
        }

        /* Value 文字（仅把硬编码 width 356.dp 改成 weight，防止屏幕宽度变化时溢出） */
        Row(
            modifier = Modifier
                .offset(x = 39.dp, y = 31.dp)
                .fillMaxWidth()                   // 改为自适应
                .padding(end = 16.dp),            // 右边留一点呼吸感
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3C2F2F),
                modifier = Modifier.weight(1f)    // 占满剩余
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

            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(8.dp))
            if (!isOutlined) {
                Icon(
                    painter = painterResource(Res.drawable.ic_edit_combined),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            if (isOutlined) {
                Icon(
                    painter = painterResource(Res.drawable.ic_signout_combined),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}