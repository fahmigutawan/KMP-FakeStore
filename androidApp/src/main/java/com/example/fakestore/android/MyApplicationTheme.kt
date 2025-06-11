package com.example.fakestore.android

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Calm and soothing color palette
private val CalmColorPalette = lightColorScheme(
    // Primary colors - Soft sage green
    primary = Color(0xFF8FBC8F),           // Sage green
    onPrimary = Color(0xFFFFFFFF),         // White
    primaryContainer = Color(0xFFE8F5E8),  // Very light sage
    onPrimaryContainer = Color(0xFF2D5016), // Dark green

    // Secondary colors - Muted lavender
    secondary = Color(0xFFB8A9C9),         // Soft lavender
    onSecondary = Color(0xFFFFFFFF),       // White
    secondaryContainer = Color(0xFFF0EDF5), // Very light lavender
    onSecondaryContainer = Color(0xFF3D2E4F), // Dark purple

    // Tertiary colors - Warm beige
    tertiary = Color(0xFFD4B896),          // Soft beige
    onTertiary = Color(0xFFFFFFFF),        // White
    tertiaryContainer = Color(0xFFF7F1E8), // Very light beige
    onTertiaryContainer = Color(0xFF5D4037), // Brown

    // Error colors - Muted coral
    error = Color(0xFFD7A3A3),             // Soft coral
    onError = Color(0xFFFFFFFF),           // White
    errorContainer = Color(0xFFF5E8E8),    // Very light coral
    onErrorContainer = Color(0xFF8B3A3A),  // Dark red

    // Background colors
    background = Color(0xFFFBFBFB),        // Off-white
    onBackground = Color(0xFF4A4A4A),      // Soft dark gray

    // Surface colors
    surface = Color(0xFFFFFFFF),           // Pure white
    onSurface = Color(0xFF4A4A4A),         // Soft dark gray
    surfaceVariant = Color(0xFFF8F8F8),    // Very light gray
    onSurfaceVariant = Color(0xFF757575),  // Medium gray

    // Outline colors
    outline = Color(0xFFE0E0E0),           // Light gray
    outlineVariant = Color(0xFFEEEEEE),    // Very light gray

    // Surface tonal colors
    surfaceTint = Color(0xFF8FBC8F),       // Same as primary
    inverseSurface = Color(0xFF4A4A4A),    // Soft dark gray
    inverseOnSurface = Color(0xFFFBFBFB),  // Off-white
    inversePrimary = Color(0xFFA8D0A8),    // Light sage

    // Scrim
    scrim = Color(0x4D000000)              // Light semi-transparent black
)

// Enhanced typography with multiple text styles
private val AppTypography = Typography(
    // Display styles - for large headings
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),

    // Headline styles - for section headings
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),

    // Title styles - for cards and dialogs
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    // Body styles - for main content
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // Label styles - for buttons and small UI elements
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

// Modern shapes with varied corner radius
private val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = CalmColorPalette,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}