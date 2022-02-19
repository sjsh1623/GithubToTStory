import {BrowserRouter, Routes, Route} from "react-router-dom";
import Main from "./pages/Main.js"
import React from "react";
import './App.css';
import TStoryAuthController from "./pages/TStoryAuthController";


function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" component={Main} />
                <Route path="/callback" component={TStoryAuthController} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
