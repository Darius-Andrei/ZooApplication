import React from 'react';
import DemoCarousel from '../Carousel/Carousel';
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
} from './NavBarElements';
  
const Navbar = () => {
  return (
    <div>
      <Nav>
        <Bars />
        <NavMenu>
          <NavLink to='/rzmap' activeStyle>
            ZooMap
          </NavLink>
          <NavLink to='/ticketstobuy' activeStyle>
            Tickete disponibile
          </NavLink>
          <NavLink to='/team' activeStyle>
            Teams
          </NavLink>
          <NavLink to='/blogs' activeStyle>
            Blogs
          </NavLink>
          <NavLink to='/registration' activeStyle>
            Sign Up
          </NavLink>
        </NavMenu>
        <NavBtn>
          <NavBtnLink to='/login'>Sign In</NavBtnLink>
        </NavBtn>
      </Nav>
      <DemoCarousel/>
    </div>
  );
};
  
export default Navbar