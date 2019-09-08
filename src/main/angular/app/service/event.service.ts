import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Rx";
import {classToPlain, plainToClass} from "class-transformer";
import {map} from "rxjs/internal/operators";
import {EventView} from "../model/view/eventView";
import {RawEvent} from "../model/tables/rawEvent";

@Injectable()
export class EventService {

    constructor(private http: HttpClient) {
    }

    // getEventsByContribution(contributionId: number): Observable<UserEvent[]> {
    //
    //     let httpParams: HttpParams = new HttpParams();
    //     httpParams = httpParams.append('contribution', contributionId.toString());
    //
    //     return this.http.get<UserEvent[]>("wallet/get-events", {params: httpParams} )
    //         .pipe(
    //             map(response => plainToClass(UserEvent, response as Object[])
    //             )
    //         );
    // }

    getEventView(): Observable<EventView[]> {
        return this.http.get<EventView[]>("wallet/get-event-view")
            .pipe(
                map(response => plainToClass(EventView, response as Object[])
                )
            );
    }


    deleteSelectedEvents(events: RawEvent[])  {
        return this.http.post("wallet/delete-events", classToPlain(events));
    }



}