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
  errorMessage: string;
  successMessage: string;

  constructor(
    private characterService: CharacterService,
    private router: Router
  ) {
    this.checkUser();
  }

  ngOnInit(): void {
    this.findAllCharacters();
  }

  checkUser() {
    const currentUser = localStorage.getItem('currentUser');
    if (currentUser !== undefined && currentUser !== null) {
      this.user = JSON.parse(currentUser);
    } else {
      this.router.navigate(['/login']);
      return;
    }
  }

  findAllCharacters() {
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

  shareCharacter(idAnime: number, shared: boolean) {
    if (idAnime === undefined) {
      this.displayMessage(
        'An error has occured while sharing the character',
        2
      );
    }
    this.characterService
      .shareCharacter(idAnime, shared)
      .pipe()
      .subscribe(
        (data) => {
          this.displayMessage('Character was successfully updated', 1);
          this.findAllCharacters();
        },
        (error) => {
          this.displayMessage(
            'An error has occured while sharing the character',
            2
          );
        }
      );
  }

  displayMessage(message: string, type: number) {
    if (type === 1) {
      this.successMessage = message;
      setTimeout(() => {
        this.successMessage = '';
      }, 5000);
    } else if (type === 2) {
      this.errorMessage = message;
      setTimeout(() => {
        this.errorMessage = '';
      }, 5000);
    }
  }
}
