/*******************************************************************************
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *******************************************************************************/
package org.black.kotlin.projectsextensions.maven.lookup;

import org.black.kotlin.projectsextensions.KotlinPrivilegedTemplates;
import org.black.kotlin.projectsextensions.maven.MavenProjectOpenedHook;
import org.black.kotlin.projectsextensions.maven.classpath.MavenClassPathProviderImpl;
import org.netbeans.modules.maven.NbMavenProjectImpl;
import org.netbeans.spi.project.LookupProvider;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Alexander.Baratynski
 */
public class MavenProjectLookupProviderExtension implements LookupProvider {

    @Override
    public Lookup createAdditionalLookup(Lookup lkp) {
        NbMavenProjectImpl project = lkp.lookup(NbMavenProjectImpl.class);
        
        return Lookups.fixed(new KotlinPrivilegedTemplates(),
                new MavenProjectOpenedHook(project),
                new MavenClassPathProviderImpl(project)
        );
    }

}