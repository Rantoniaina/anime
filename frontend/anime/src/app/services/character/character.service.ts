import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Character } from 'src/app/models/character';
import { AppSettings } from 'src/app/settings/app.settings';

@Injectable({
  providedIn: 'root',
})
export class CharacterService {
  constructor(private http: HttpClient) {}

  findAllCharacters() {
    return this.http.get<Character>(AppSettings.APP_URL + '/animes/');
  }

  findCharacterById(idCharacter: number) {
    return this.http.get<Character>(
      AppSettings.APP_URL + '/animes/' + idCharacter
    );
  }

  saveCharacter(character: Character) {
    return this.http.post(AppSettings.APP_URL + '/animes/', character);
  }

  shareCharacter(idCharacter: number, isShared: boolean) {
    return this.http.get<Character>(
      AppSettings.APP_URL + '/animes/share/' + idCharacter + '/' + isShared
    );
  }
}
