import { Component, inject } from "@angular/core";
import { MatDialogModule, MatDialogRef } from "@angular/material/dialog";
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { PhotoPreviewComponent } from "../photo-preview/photo-preview.component";

@Component({
  selector: "app-modal-create-auction",
  standalone: true,
  imports: [
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    PhotoPreviewComponent,
  ],
  templateUrl: "./modal-create-auction.component.html",
  styleUrl: "./modal-create-auction.component.scss",
})
export class ModalCreateAuctionComponent {
  private dialogRef: MatDialogRef<ModalCreateAuctionComponent> = inject(
    MatDialogRef<ModalCreateAuctionComponent>
  );

  public create(): void {
    this.dialogRef.close();
  }
}
