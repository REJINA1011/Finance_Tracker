import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSnackBarRef, MatSnackBarConfig, SimpleSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {
  constructor(private snackBar: MatSnackBar) { }

  showMessage(message: string, action: string = 'OK', duration: number = 5000, reload: boolean = false): MatSnackBarRef<SimpleSnackBar> {
    const config: MatSnackBarConfig = {
      duration: duration,
      horizontalPosition: 'center',
      verticalPosition: 'top',
    };
    const snackBarRef = this.snackBar.open(message, action, config);

    // Subscribe to the onAction observable
    snackBarRef.onAction().subscribe(() => {
      if (reload) {
        // Reload the page
        window.location.reload();
      }
    });

    return snackBarRef;
  }
}
