import 'package:flutter/material.dart';
import 'package:get/get.dart';

class HomeView extends StatelessWidget {
  const HomeView({super.key});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context); // access current theme

    return Scaffold(
      backgroundColor: theme.colorScheme.background, // respects dark/light mode
      body: SafeArea(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Padding(
              padding:
              const EdgeInsets.symmetric(horizontal: 16.0, vertical: 10),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Image.asset('assets/newlogo.jpeg', width: 60),
                  const SizedBox(width: 10),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        'लघु जल संसाधन विभाग',
                        style: theme.textTheme.titleMedium?.copyWith(
                          fontWeight: FontWeight.bold,
                          color: Colors.red, // stays red by design
                        ),
                      ),
                      Text(
                        'Minor Water Resources Department | Govt. of Bihar',
                        style: theme.textTheme.bodySmall,
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
