import React, { Component } from 'react';
import axios from 'axios';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

class Paciente extends Component {
  constructor(props) {
    super(props);
    this.state = {
      pacientes: []
    };
  }

  componentDidMount() {
    axios.get('http://localhost:8080/hospital/paciente/')
      .then(res => {
        this.setState({ pacientes: res.data.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    const { pacientes } = this.state;
    return (
      <div className="card mt-3">
        <DataTable value={pacientes} className="p-datatable-gridlines">
          <Column field="id" header="Id" />
          <Column field="nombre" header="Nombre" />
          <Column field="apellidos" header="Apellido" />
          <Column field="numeroSeguro" header="Número de Seguro" />
          <Column field="sexo" header="Sexo" />
          <Column field="alturaMetros" header="Altura (Mts)" />
          <Column field="pesoKg" header="Peso (Kg)" />
          <Column field="edad" header="Edad" />
        </DataTable>
      </div>
    );
  }
}

export default Paciente;