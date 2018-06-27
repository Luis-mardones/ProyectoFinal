import { Component } from '@angular/core';
import { Http, Response} from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'al club de la pelea';
   idProducto = '';
    descripcionProducto = '';
     precioProducto = '';

     idInsert = '';
     codeInsert = '';
     descripcionInsert = '';
     precioInsert = '';


      constructor(private http: Http) {}

       searchIndicator() {
        this.http.get('http://localhost:8080/api/product/'+ this.idProducto)
         .subscribe(
          (res: Response) => {
            const datos = res.json();
            console.log(datos);
            this.descripcionProducto = datos['description'];
            this.precioProducto = datos['precio'];
             }, err => {
              console.log('UPS!');
              console.log(err);
           }, () => {
             console.log('¡Servicio Finalizado!');
             // https://angular.io/guide/quickstart
             // https://materializecss.com/
           }
       );
     }

     insertIndicator() {
      this.http.get('http://localhost:8080/api/products')
       .subscribe(
        (res: Response) => {
          const datos = res.json();
          console.log(datos);
          this.descripcionProducto = datos['description'];
          this.precioProducto = datos['precio'];
           }, err => {
            console.log('UPS!');
            console.log(err);
         }, () => {
           console.log('¡Servicio Finalizado!');
           // https://angular.io/guide/quickstart
           // https://materializecss.com/
         }
     );
   }
}
