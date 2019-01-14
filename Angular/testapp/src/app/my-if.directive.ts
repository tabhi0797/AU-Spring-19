import { Directive, TemplateRef, ViewContainerRef, Input, HostBinding } from '@angular/core';

@Directive({
  selector: '[appMyIf]'
})
export class MyIfDirective {


  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef) { }

  @Input() set appMyIf(condition: boolean) {
    if (condition) {
      this.viewContainer.createEmbeddedView(this.templateRef);
      // this.changeText();
    } else if (!condition) {
      this.viewContainer.clear();
    }

  }

  /*changeText(){
    this.templateRef.elementRef.nativeElement.innerText = this.val;
  }*/
}
