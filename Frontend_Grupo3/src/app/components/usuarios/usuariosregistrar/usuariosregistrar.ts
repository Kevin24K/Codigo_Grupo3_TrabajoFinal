import { Component, OnInit } from '@angular/core'; 
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators, } from '@angular/forms'; 
import { MatButtonModule } from '@angular/material/button'; 
import { MatFormFieldModule } from '@angular/material/form-field'; 
import { MatInputModule } from '@angular/material/input'; 
import { MatSelectModule } from '@angular/material/select'; 
import { ActivatedRoute, Params, Router } from '@angular/router'; 
import { MatRadioModule } from '@angular/material/radio'; // Importamos MatRadioModule aquí 
import { Users } from '../../../models/Usuarios'; 
import { Rol } from '../../../models/Rol'; 
import { RolService } from '../../../services/rol-service'; 
import { UsuarioService } from '../../../services/usuarios-service'; 

@Component({ 
  selector: 'app-usuariosregistrar', 
  imports: [ 
    ReactiveFormsModule, 
    MatInputModule, 
    MatFormFieldModule, 
    MatButtonModule, 
    MatSelectModule, 
    MatRadioModule, 
  ], 
  templateUrl: './usuariosregistrar.html', 
  styleUrl: './usuariosregistrar.css', 
}) 

export class Usuariosregistrar implements OnInit { 
  form: FormGroup = new FormGroup({}); 
  usuario: Users = new Users(); 
  edicion: boolean = false; 
  id: number = 0; 
  listaRoles: Rol[] = []; 

  constructor( 
    private uService: UsuarioService, 
    private rService: RolService, 
    private router: Router, 
    private formBuilder: FormBuilder, 
    private route: ActivatedRoute 
  ) {}

  ngOnInit(): void { 
    this.route.params.subscribe((data: Params) => { 
      this.id = data['id']; 
      this.edicion = this.id != null; 
      this.init(); 
    });

    // Crear el formulario
    this.form = this.formBuilder.group({
      codigo: [''],
      username: ['', Validators.required],
      password: ['', Validators.required],
      enabled: ['', Validators.required],
    });
  }

  aceptar(): void { 
    this.form.markAllAsTouched(); 

    if (!this.form.valid) { 
      return; 
    }

    this.usuario.id = this.form.value.codigo;
    this.usuario.username = this.form.value.username;
    this.usuario.password = this.form.value.password;
    this.usuario.enabled = this.form.value.enabled;

    // Actualizar o insertar usuario
    if (this.edicion) {
      this.uService.update(this.usuario).subscribe(() => {
        this.uService.list().subscribe((data) => {
          this.uService.setList(data);
        });
      });
    } else {
      this.uService.insert(this.usuario).subscribe(() => {
        this.uService.list().subscribe((data) => {
          this.uService.setList(data);
        });
      });
    }

    // Redirigir a la lista de usuarios
    this.router.navigate(['usuarios']);
  }

  init() {
    if (this.edicion) {
      this.uService.listId(this.id).subscribe((data) => {
        this.form.setValue({
          codigo: data.id,
          username: data.username,
          password: data.password,
          enabled: data.enabled,
        });
      });
    }
  }

  cancelar() { 
    this.router.navigate(['/usuarios']); 
  } 
} 
