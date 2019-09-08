import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Rx";
import {classToPlain, plainToClass} from "class-transformer";
import {map} from "rxjs/internal/operators";
import {RawResource} from "../model/tables/rawResource";
import {ResourceView} from "../model/view/resourceView";
import {UserView} from "../model/view/userView";

@Injectable()
export class UserService {

    constructor(private http: HttpClient) {
    }

    getUserView(): Observable<UserView[]> {
        return this.http.get<UserView[]>("wallet/get-user-view" )
            .pipe(
                map(response => plainToClass(UserView, response as Object[])
                )
            );
    }

}