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
import types.AffinityGroup;

/**
 * Affinity groups service manages virtual machine relationships and dependencies.
 *
 * @author Martin Sivak <msivak@redhat.com>
 * @date 14 Sep 2016
 * @status added
 */
@Service
@Area("SLA")
public interface AffinityGroupsService {
    /**
     * Create a new affinity group.
     *
     * Post a request like in the example below to create a new affinity group:
     *
     * [source]
     * ----
     * POST /ovirt-engine/api/clusters/000-000/affinitygroups
     * ----
     *
     * And use the following example in its body:
     *
     * [source,xml]
     * ----
     * <affinity_group>
     *   <name>AF_GROUP_001</name>
     *   <positive>true</positive>
     *   <enforcing>true</enforcing>
     * </affinity_group>
     * ----
     *
     * @author Martin Sivak <msivak@redhat.com>
     * @date 14 Sep 2016
     * @status added
     */
    interface Add {
        /**
         * The affinity group object to create.
         *
         * @author Martin Sivak <msivak@redhat.com>
         * @date 14 Sep 2016
         * @status added
         */
        @In @Out AffinityGroup group();
    }

    /**
     * List existing affinity groups.
     *
     * @author Martin Sivak <msivak@redhat.com>
     * @date 14 Sep 2016
     * @status added
     */
    interface List {
        /**
         * The list of existing affinity groups.
         *
         * @author Martin Sivak <msivak@redhat.com>
         * @date 14 Sep 2016
         * @status added
         */
        @Out AffinityGroup[] groups();

        /**
         * Sets the maximum number of affinity groups to return. If not specified all the affinity groups are returned.
         */
        @In Integer max();
    }

    /**
     * Access affinity group service that manages the affinity group specified by an id.
     *
     * @author Martin Sivak <msivak@redhat.com>
     * @date 14 Sep 2016
     * @status added
     */
    @Service AffinityGroupService group(String id);
}
