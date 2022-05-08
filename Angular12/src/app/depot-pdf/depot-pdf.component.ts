import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {DepotDeGaranties} from "../Modal/depot-de-garanties";
import {DepotDeGarantiesService} from "../Service/depot-de-garanties.service";
import html2canvas from "html2canvas";
import jsPDF from "jspdf";
@Component({
  selector: 'app-depot-pdf',
  templateUrl: './depot-pdf.component.html',
  styleUrls: ['./depot-pdf.component.css']
})
export class DepotPdfComponent implements OnInit {
  @ViewChild('htmlData') htmlData!: ElementRef;
  listDepot : any;
  depot!:DepotDeGaranties
  constructor(private depotS : DepotDeGarantiesService) { }

  ngOnInit(): void {
    this.getDepot()
    this.depot = {
      id:null,
      moisLoyers:null,
      Somme:null,
      numeroPayment:null,
      caution:null,
      editedAt:null,
      etat:null,
      user:null
    }
  }
  getDepot()
  {
    this.depotS.getDepot().subscribe((res) =>this.listDepot = res);
  }
  public openPDF(): void {
    let DATA: any = document.getElementById('htmlData');
    html2canvas(DATA).then((canvas) => {
      let fileWidth = 208;
      let fileHeight = (canvas.height * fileWidth) / canvas.width;
      const FILEURI = canvas.toDataURL('image/png');
      let PDF = new jsPDF('p', 'mm', 'a4');
      let position = 0;
      PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight);
      PDF.save('angular-demo.pdf');
    });
  }
}
