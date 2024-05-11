import React from 'react';
import {  Routes, Route } from "react-router-dom";

import Layout from './pages/homepage/layout';
import Home from './pages/homepage/home';

export default function App(){
  return (
    <div>
      <Routes>
          <Route path="/" element={<Layout/>}>
            <Route index element={<Home/>}/>
          </Route>
      </Routes>
    </div>
  )
}
