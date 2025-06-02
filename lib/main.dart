import 'package:flutter/material.dart';
// import 'package:flutter/services.dart'; // No longer needed here
import 'package:get/get.dart';
import 'app/routes/app_pages.dart';
import 'app/services/auth_service.dart'; // Import AuthService
// import 'package:myapp1/animated_splash_view.dart'; // Remove this import

Future<void> main() async { // Make main async
  WidgetsFlutterBinding.ensureInitialized();
  await initServices(); // Initialize services before running the app
  // SystemChrome.setSystemUIOverlayStyle(SystemUiOverlayStyle.dark.copyWith(
  //   statusBarColor: Colors.transparent,      
  //   statusBarIconBrightness: Brightness.dark, 
  //   statusBarBrightness: Brightness.light,    
  // )); // This global setting is removed as AppHeader now handles it.
  runApp(const MyApp());
}

// Function to initialize services
Future<void> initServices() async {
  print("Initializing services...");
  await Get.putAsync(() => AuthService().init());
  // Add other services here if needed in the future
  print("Services initialized!");
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // Define a base dark color scheme for Material 3 style
    const darkColorScheme = ColorScheme(
      brightness: Brightness.dark,
      primary: Color(0xFFBB86FC), // Example: Deep Purple - A common M3 dark primary
      onPrimary: Colors.black,
      primaryContainer: Color(0xFF3700B3), // Darker variant for containers
      onPrimaryContainer: Colors.white,
      secondary: Color(0xFF03DAC6), // Example: Teal
      onSecondary: Colors.black,
      secondaryContainer: Color(0xFF303030), // Darker grey for secondary containers like action buttons
      onSecondaryContainer: Colors.white,
      tertiary: Color(0xFF3700B3),
      onTertiary: Colors.white,
      tertiaryContainer: Color(0xFF4F378B),
      onTertiaryContainer: Colors.white, 
      error: Color(0xFFCF6679), // Standard M3 error color
      onError: Colors.black,
      surface: Color(0xFF1E1E1E), // Slightly lighter than background for surfaces like cards
      onSurface: Colors.white,
      surfaceContainerLowest: Color(0xFF121212), // Replaces background
      surfaceContainer: Color(0xFF2C2C2C), // Replaces surfaceVariant
      outline: Colors.grey,
      shadow: Colors.black,
      inverseSurface: Color(0xFFE0E0E0),
      onInverseSurface: Colors.black,
      inversePrimary: Color(0xFF6200EE),      
    );

    return GetMaterialApp(
      title: 'Login App',
      debugShowCheckedModeBanner: false,
      themeMode: ThemeMode.system, // This respects system theme settings
      theme: ThemeData.light().copyWith(
        // Custom light theme properties if needed
        // e.g., cardColor: Colors.white,
        // textTheme: ThemeData.light().textTheme.apply(bodyColor: Colors.black, displayColor: Colors.black)
        colorScheme: ThemeData.light().colorScheme.copyWith(
            // primary: Colors.green, // Example for light theme primary
            // secondary: Colors.blue,
            ),
      ),
      darkTheme: ThemeData.from(colorScheme: darkColorScheme).copyWith(
        // Custom dark theme properties if needed
        // e.g., cardColor: Colors.grey[850],
        // textTheme: ThemeData.dark().textTheme.apply(bodyColor: Colors.white, displayColor: Colors.white)
        // Further specific overrides for dark theme if ThemeData.from isn't enough
        // cardColor: darkColorScheme.surface, // Explicitly set if needed, but ThemeData.from should handle
        // scaffoldBackgroundColor: darkColorScheme.background, 
      ),
      initialRoute: AppPages.INITIAL,
      getPages: AppPages.routes,
    );
  }
}
