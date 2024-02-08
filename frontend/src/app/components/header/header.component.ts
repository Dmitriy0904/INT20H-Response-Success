import { Component, OnDestroy, inject } from "@angular/core";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { RouterModule } from "@angular/router";
import { MatDialog, MatDialogModule } from "@angular/material/dialog";
import { ModalCreateAuctionComponent } from "../modal-create-auction/modal-create-auction.component";
import { Subject, takeUntil } from "rxjs";

@Component({
  selector: "app-header",
  standalone: true,
  imports: [
    RouterModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatDialogModule,
  ],
  templateUrl: "./header.component.html",
  styleUrl: "./header.component.scss",
})
export class HeaderComponent implements OnDestroy {
  private dialog: MatDialog = inject(MatDialog);
  private destroy$: Subject<void> = new Subject<void>();

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  public openDialog(): void {
    const dialogRef = this.dialog.open(ModalCreateAuctionComponent);

    dialogRef
      .afterClosed()
      .pipe(takeUntil(this.destroy$))
      .subscribe((result) => {
        console.log(`Dialog result: ${result}`);
      });
  }
}
