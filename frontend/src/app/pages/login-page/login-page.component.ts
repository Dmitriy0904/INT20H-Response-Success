import { Component, inject } from "@angular/core";
import { MatInputModule } from "@angular/material/input";
import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { RouterModule } from "@angular/router";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: "app-login-page",
  standalone: true,
  imports: [RouterModule, MatInputModule, MatCardModule, MatButtonModule],
  templateUrl: "./login-page.component.html",
  host: { class: "auth-form" },
})
export class LoginPageComponent {
  authService: AuthService = inject(AuthService);
}
