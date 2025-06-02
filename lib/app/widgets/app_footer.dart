import 'package:flutter/material.dart';

class AppFooter extends StatelessWidget {
  const AppFooter({super.key});

  @override
  Widget build(BuildContext context) {
    final ThemeData theme = Theme.of(context);
    return Container(
      color: theme.colorScheme.surfaceContainerHighest,
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Center(
        child: Text(
          'Services provided by: NIC Bihar',
          style: TextStyle(color: theme.colorScheme.onSurfaceVariant, fontSize: 13),
        ),
      ),
    );
  }
} 