import { Component, inject } from "@angular/core";
import { MatInputModule } from "@angular/material/input";
import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { RouterModule } from "@angular/router";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: "app-register-page",
  standalone: true,
  imports: [RouterModule, MatInputModule, MatCardModule, MatButtonModule],
  templateUrl: "./register-page.component.html",
  host: { class: "auth-form" },
})
export class RegisterPageComponent {
  authService: AuthService = inject(AuthService);
}
