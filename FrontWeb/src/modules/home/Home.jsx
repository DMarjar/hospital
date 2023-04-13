import React from 'react'
import { NavbarA } from '../../shared/components/NavbarA'
import { Row, Col } from 'react-bootstrap'
import AsideA from '../../shared/components/AsideA'
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Medicina from '../medicina/Medicina';
import Medico from '../medico/Medico';
import Paciente from '../paciente/Paciente';
import Preescripcion from '../preescripcion/Preescripcion';
import Usuario from '../usuario/Usuario';
import Consultorio from '../consultorio/Consultorio';

export const Home = () => {
    return (
        <>
            <div className="container-fluid">
                <Row className="m-0">
                    <NavbarA />
                </Row>
                <Row className="h-100 square border border-2 border-light " style={{ height: "100vh" }}>
                    <Col
                        className="col-lg-2 col-md-3 col-sm-3 square border border-bottom-0 m-0"
                        style={{ height: "600px", position: "relative" }}
                    >
                        <AsideA />
                    </Col>
                    <Col className="col-lg-10 col-md-9 col-sm-9 square border border-bottom-0 m-0">
                        <section className="container-fluid">
                            <Routes>
                                <Route path="/hospital/medicina" element={<Medicina/>}/>
                                <Route path="/hospital/medico" element={<Medico/>} />
                                <Route path="/hospital/paciente" element={<Paciente/>}></Route> {/* <h1>INDICADORES </h1> */}
                                <Route path="/hospital/preescripcion" element={<Preescripcion/>}></Route> {/*<h1>Candidates, dataTable</h1>*/}
                                <Route path="/hospital/usuario" element={<Usuario/>}></Route> {/* <h1>Personal certificador, misma tabla de candidates</h1> */}
                                <Route path="/hospital/consultorio" element={<Consultorio/>}></Route> {/* <h1>Personal certificador, misma tabla de candidates</h1> */}
                            </Routes>
                        </section>
                    </Col>
                </Row>
            </div>
        </>
    )
}