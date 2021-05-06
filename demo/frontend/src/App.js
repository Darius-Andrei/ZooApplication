import "./App.css";

import RenderUsers from "./Users/RenderUsers";
import InsertUser from "./Users/InsertUser";
import InsertZoo from "./Zoo/InsertZoo";
import RenderZoo from "./Zoo/RenderZoo";
import RenderAnimal from "./Animals/RenderAnimal";
import RenderZooMap from "./ZooMap/RenderZooMap";
import InsertAnimal from "./Animals/InsertAnimal";
import InsertZooMap from "./ZooMap/InsertZooMap";
import Login_User from "./Login_User/Login_User";
import Logout from "./Login_User/LoggedIn";
import InsertTicket from"./Ticket/InsertTicket";
import RenderTicket from "./Ticket/RenderTicket";
import { BrowserRouter, Route , Link } from "react-router-dom";
import Registration from "./Register/Registration";
import NumberOfTickets from "./Ticket/NumberOfTickets";
import RenderUserTickets from "./Ticket/RenderUsersTickets";
import InsertPicture from "./Animals/InsertPicture";
import Navbar from "./Navbar/NavigationBar";
import DemoCarousel from "./Carousel/Carousel";
import PayPalFake from "./Payment/PayPalFake";

function App() {
  return (
    <BrowserRouter>
      <Route exact path='/users/create' component={InsertUser} />
      <Route exact path='/users' component={RenderUsers} />
      <Route exact path='/zoo' component={InsertZoo} />
      <Route exact path='/renderzoo' component={RenderZoo} />
      <Route exact path='/zooMap' component={InsertZooMap} />
      <Route exact path='/rzmap' component={RenderZooMap} />
      <Route exact path='/ianimal' component={InsertAnimal} />
      <Route exact path='/ranimal' component={RenderAnimal} />
      <Route exact path='/tickets' component={InsertTicket} />
      <Route exact path='/rtickets' component={RenderTicket} />
      <Route exact path='/registration' component={Registration} />
      <Route exact path='/ticketstobuy' component={NumberOfTickets} />
      <Route exact path='/userTickets' component={RenderUserTickets} />
      <Route exact path='/picture' component={InsertPicture} />
      <Route exact path='/carousel' component={DemoCarousel} />
      <Route exact path='/paypal' component={PayPalFake} />
      <Route exact path='/' component={Navbar} />
      
      {localStorage.getItem("session")!=undefined ? 
      <Route exact path='/login' component={Logout} />
      :<Route exact path='/login' component={Login_User} />}
    </BrowserRouter>
  );
}

export default App;
