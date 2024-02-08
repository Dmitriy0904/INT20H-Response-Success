import { Component, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-photo-preview",
  standalone: true,
  imports: [],
  templateUrl: "./photo-preview.component.html",
  styleUrl: "./photo-preview.component.scss",
})
export class PhotoPreviewComponent implements OnInit {
  @Input() isEditable: boolean = false;

  public selectedImage: string = "assets/images/image-placeholder.jpg";

  private fileReader: FileReader = new FileReader();

  ngOnInit(): void {
    this.handleOnLoad();
  }

  public setSelectedFile(event: Event): void {
    const element = event.target as HTMLInputElement;

    if (!element.files) return;

    const file = element.files[0];

    if (file) {
      this.fileReader.readAsDataURL(file);
    }
  }

  private handleOnLoad(): void {
    this.fileReader.onload = (e) => {
      this.selectedImage = e.target?.result as string;
    };
  }
}
