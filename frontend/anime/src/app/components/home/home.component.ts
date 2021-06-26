import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Character } from 'src/app/models/character';
import { User } from 'src/app/models/user';
import { CharacterService } from 'src/app/services/character/character.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  user: User;
  animeCharacters: Character[];

  constructor(
    private characterService: CharacterService,
    private router: Router
  ) {
    this.checkUser();
  }

  ngOnInit(): void {
    this.characterService
      .findAllUserCharacters(this.user.idUsers)
      .pipe()
      .subscribe(
        (data) => {
          this.animeCharacters = data;
        },
        (error) => {
          console.log(error);
        }
      );
  }

  checkUser() {
    const currentUser = localStorage.getItem('currentUser');
    if (currentUser !== undefined && currentUser !== null) {
      console.log({ currentUser });

      this.user = JSON.parse(currentUser);
    } else {
      this.router.navigate(['/login']);
      return;
    }
  }
}
