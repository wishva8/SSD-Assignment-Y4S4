import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class StateService {
  constructor() { }

  private roles = new BehaviorSubject<[]>([]);
  private projectidSource = new BehaviorSubject<Number>(new Number());
  private epicidSource = new BehaviorSubject<Number>(new Number());
  private sprintidSource = new BehaviorSubject<Number>(new Number());
  private taskidSource = new BehaviorSubject<Number>(new Number());
  private issueidSource = new BehaviorSubject<Number>(new Number());
  private storyidSource = new BehaviorSubject<Number>(new Number());


  userRoles = this.roles.asObservable();
  selectedProjectId = this.projectidSource.asObservable();
  selectedEpicId = this.epicidSource.asObservable();
  selectedSprintId = this.sprintidSource.asObservable();
  selectedTaskId = this.taskidSource.asObservable();
  selectedIssueId = this.issueidSource.asObservable();
  selectedStoryId = this.storyidSource.asObservable();


  setUserRoles(roles) { this.roles.next(roles) }
  setprojectid(projectid) { this.projectidSource.next(projectid) }
  setepicid(epicid) { this.epicidSource.next(epicid) }
  setsprintid(sprintid) { this.sprintidSource.next(sprintid) }
  settaskid(taskid) { this.taskidSource.next(taskid) }
  setissueid(issueid) { this.issueidSource.next(issueid) }
  setstoryid(storyid) { this.storyidSource.next(storyid) }
}
