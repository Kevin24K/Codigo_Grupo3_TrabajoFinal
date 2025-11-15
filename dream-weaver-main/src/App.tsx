import { Toaster } from "@/components/ui/toaster";
import { Toaster as Sonner } from "@/components/ui/sonner";
import { TooltipProvider } from "@/components/ui/tooltip";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Layout } from "@/components/Layout";
import Dashboard from "./pages/Dashboard";
import RegistroSuenio from "./pages/RegistroSuenio";
import Alarmas from "./pages/Alarmas";
import Musica from "./pages/Musica";
import Habitos from "./pages/Habitos";
import Actividades from "./pages/Actividades";
import Objetivos from "./pages/Objetivos";
import Recompensas from "./pages/Recompensas";
import Evaluacion from "./pages/Evaluacion";
import Admin from "./pages/Admin";
import AdminUsers from "./pages/AdminUsers";
import NotFound from "./pages/NotFound";

const queryClient = new QueryClient();

const App = () => (
  <QueryClientProvider client={queryClient}>
    <TooltipProvider>
      <Toaster />
      <Sonner />
      <BrowserRouter>
        <Layout>
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/suenio" element={<RegistroSuenio />} />
            <Route path="/alarmas" element={<Alarmas />} />
            <Route path="/musica" element={<Musica />} />
            <Route path="/habitos" element={<Habitos />} />
            <Route path="/actividades" element={<Actividades />} />
            <Route path="/objetivos" element={<Objetivos />} />
            <Route path="/recompensas" element={<Recompensas />} />
            <Route path="/evaluacion" element={<Evaluacion />} />
            <Route path="/admin" element={<Admin />} />
            <Route path="/admin/users" element={<AdminUsers />} />
            <Route path="/admin/recompensas" element={<Admin />} />
            <Route path="/admin/tipos-musica" element={<Admin />} />
            <Route path="/admin/musica" element={<Admin />} />
            <Route path="/admin/notificaciones" element={<Admin />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </Layout>
      </BrowserRouter>
    </TooltipProvider>
  </QueryClientProvider>
);

export default App;
