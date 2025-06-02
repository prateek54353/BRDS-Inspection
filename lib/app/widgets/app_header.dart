import 'package:flutter/material.dart';
import 'package:flutter/services.dart'; // For AnnotatedRegion and SystemUiOverlayStyle

class AppHeader extends StatelessWidget {
  const AppHeader({super.key});

  @override
  Widget build(BuildContext context) {
    final ThemeData theme = Theme.of(context);
    final bool isDarkMode = theme.brightness == Brightness.dark;

    // Determine status bar icon brightness based on theme
    final SystemUiOverlayStyle systemUiOverlayStyle = isDarkMode
        ? SystemUiOverlayStyle.light.copyWith(statusBarColor: Colors.transparent)
        : SystemUiOverlayStyle.dark.copyWith(statusBarColor: Colors.transparent);

    return AnnotatedRegion<SystemUiOverlayStyle>(
      value: systemUiOverlayStyle,
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Container(
            color: theme.colorScheme.surfaceContainerHighest,
            padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 10),
            child: Row(
              children: [
                Image.asset(
                  'assets/newlogo.jpeg', // Consider providing a dark theme variant if needed
                  width: 60,
                  height: 60,
                  fit: BoxFit.contain,
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: Center(
                    child: Text(
                      'BRDS Inspection',
                      style: TextStyle(
                        color: theme.colorScheme.onSurfaceVariant,
                        fontWeight: FontWeight.bold,
                        fontSize: 22,
                      ),
                    ),
                  ),
                ),
                const SizedBox(width: 8),
                Image.asset(
                  'assets/govbihar.png', // Consider providing a dark theme variant if needed
                  width: 60,
                  height: 60,
                  fit: BoxFit.contain,
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}