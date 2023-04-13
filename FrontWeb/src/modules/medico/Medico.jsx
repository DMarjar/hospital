import React, { Component } from 'react';
import axios from 'axios';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

class Medico extends Component {
  constructor(props) {
    super(props);
    this.state = {
      medicos: []
    };
  }

  componentDidMount() {
    axios.get('http://localhost:8080/hospital/medico/')
      .then(res => {
        this.setState({ medicos: res.data.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    const { medicos } = this.state;
    return (
      <div className="card  mt-3">
        <DataTable value={medicos} className="p-datatable-gridlines">
          <Column field="id" header="Id" />
          <Column field="nombre" header="Nombre" />
          <Column field="apellidos" header="Apellido" />
          <Column field="sexo" header="Sexo" />
          <Column field="edad" header="Edad" />
          <Column field="especialidad" header="Especialidad" />
        </DataTable>
      </div>
    );
  }
}

export default Medico;