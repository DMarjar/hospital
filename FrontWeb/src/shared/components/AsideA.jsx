import React from 'react'
import { Row, Nav } from 'react-bootstrap'
import { GiMedicines } from 'react-icons/gi'
import { AiFillMedicineBox } from 'react-icons/ai'
import { BsPersonWorkspace } from 'react-icons/bs'
import { SiReadthedocs } from 'react-icons/si'
import { FaUserFriends } from 'react-icons/fa'
import { RiHospitalFill } from 'react-icons/ri'
import { NavLink } from 'react-router-dom'

export const AsideA = () => {
    return (
        <>
            <Nav className='px-3 py-2 mt-3 text-center'><h4 style={{ color: "#002e60" }}>Registros</h4></Nav>
            <hr className='mt-1' />
            <Row className='pb-2'>
                <NavLink style={{ textDecoration: 'none', color: 'black' }} className='pt-1 px-3' to="/hospital/medicina"><GiMedicines size={"35"} color="#002e60" />&nbsp; Medicina</NavLink>
            </Row>
            <Row className='pb-2'>
                <NavLink style={{ textDecoration: 'none', color: 'black' }} className='pt-1 px-3' to="/hospital/medico"><AiFillMedicineBox size={"35"} color="#002e60" />&nbsp; Médico </NavLink>
            </Row>
            <Row className='pb-2'>
                <NavLink style={{ textDecoration: 'none', color: 'black' }} className='pt-1 px-3' to="/hospital/paciente"><BsPersonWorkspace size={"35"} color="#002e60" />&nbsp; Paciente </NavLink>
            </Row>
            <Row className='pb-2'>
                <NavLink style={{ textDecoration: 'none', color: 'black' }} className='pt-1 px-3' to="/hospital/preescripcion"><SiReadthedocs size={"35"} color="#002e60" />&nbsp; Preescripción </NavLink>
            </Row>
            <Row className='pb-2'>
                <NavLink style={{ textDecoration: 'none', color: 'black' }} className='pt-1 px-3' to="/hospital/usuario"><FaUserFriends size={"35"} color="#002e60" />&nbsp; Usuario </NavLink>
            </Row>
            <Row className='pb-2'>
                <NavLink style={{ textDecoration: 'none', color: 'black' }} className='pt-1 px-3' to="/hospital/consultorio"><RiHospitalFill size={"35"} color="#002e60" />&nbsp; Consultorio </NavLink>
            </Row>
        </>
    )
}

export default AsideA