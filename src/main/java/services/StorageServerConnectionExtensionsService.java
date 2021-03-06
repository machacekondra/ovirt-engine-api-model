/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package services;

import annotations.Area;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import types.StorageConnectionExtension;

@Service
@Area("Storage")
public interface StorageServerConnectionExtensionsService {

    /**
     * Creates a new storage server connection extension for the given host.
     *
     * The extension lets the user define credentials for an iSCSI target for a specific host. For example to use
     * `myuser` and `mypassword` as the credentials when connecting to the iSCSI target from host `123` send a request
     * like this:
     *
     * [source]
     * ----
     * POST /ovirt-engine/api/hosts/123/storageconnectionextensions
     * ----
     *
     * With a request body like this:
     *
     * [source,xml]
     * ----
     * <storage_connection_extension>
     *   <target>iqn.2016-01.com.example:mytarget</target>
     *   <username>myuser</username>
     *   <password>mypassword</password>
     * </storage_connection_extension>
     * ----
     *
     * @author Tal Nisan <tnisan@redhat.com>
     * @date 20 Sep 2016
     * @status added
     */
    interface Add {
        @In @Out StorageConnectionExtension extension();
    }

    interface List {
        @Out StorageConnectionExtension[] extensions();

        /**
         * Sets the maximum number of extensions to return. If not specified all the extensions are returned.
         */
        @In Integer max();
    }

    @Service StorageServerConnectionExtensionService storageConnectionExtension(String id);
}
