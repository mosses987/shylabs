import {BrowserRouter, Route, Switch, Redirect} from 'react-router-dom';
import Navbar from './Components/Navbar';
import Home from './Components/Home';
import StudentList from './Components/StudentList';
import AddStudent from './Components/AddStudent';
import AddCourse from './Components/AddCourse';
import CourseList from './Components/CourseList';
import NotFound from './Components/NotFound';
import AddResult from './Components/AddResult';
import ResultList from './Components/ResultList';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Navbar />
        <Switch>


          <Route exact path='/' component={Home}>
            <Home />
          </Route>

          <Route exact path='/Home' component={Home}>
            <Home /> 
          </Route>

          <Route exact path='/addstudent' component={AddStudent}>
            <AddStudent /> 
          </Route>

          <Route exact path='/liststudent' component={StudentList}>
            <StudentList />
          </Route>

          <Route exact path='/addcourse' component={AddCourse}>
            <AddCourse/>
          </Route> 

          <Route exact path='/listcourse' component={CourseList}>
            <CourseList/>
          </Route>

          <Route exact path='/addresult' component={AddResult}>
            <AddResult />
          </Route>

          <Route exact path='/resultlist' component={ResultList}>
            <ResultList />
          </Route>

          <Route component=
            {NotFound}>

          </Route>

          

        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
